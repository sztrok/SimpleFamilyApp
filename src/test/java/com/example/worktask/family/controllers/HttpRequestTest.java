package com.example.worktask.family.controllers;

import com.example.worktask.family.data.Family;
import com.example.worktask.family.exceptions.FamilyNotFoundException;
import com.example.worktask.family.repositories.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FamilyRepository repository;

    @Test
    public void testGetException() throws Exception {
        mockMvc.perform(get("/api/get_family/0"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof FamilyNotFoundException))
                .andExpect(result -> assertEquals("Could not find family 0", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    public void testGetSuccess() throws Exception{
        Family family = new Family("TESTP",0,0,0);
        repository.save(family);
        Long id = repository.getMaxTestId();
        String resp = "{\"familyDTO\":{\"id\":"+id+",\"familyName\":\"TESTP\",\"nrOfAdults\":0,\"nrOfChildren\":0,\"nrOfInfants\":0},\"familyMemberDTOList\":[]}";
        mockMvc.perform(get("/api/get_family/{id}", id))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(result.getResponse().getContentAsString(), resp));
    }

    @Test
    public void testPostFailed() throws Exception{
        String content = """
                {
                    "familyDTO":{
                        "familyName":"FAMTEST AGE INF",
                        "nrOfAdults":"2",
                        "nrOfChildren":"1",
                        "nrOfInfants":"3"
                    },
                    "familyMemberDTOList":[
                        {
                            "givenName":"TEST INF age1",
                            "familyName":"FAMTEST AGE",
                            "age":"24"
                        },
                        {
                            "givenName":"TEST INF age2",
                            "familyName":"FAMTEST AGE",
                            "age":"25"
                        },
                        {
                            "givenName":"TEST INF age3",
                            "familyName":"FAMTEST AGE",
                            "age":"10"
                        },
                        {
                            "givenName":"TEST INF age4",
                            "familyName":"FAMTEST AGE",
                            "age":"3"
                        },
                        {
                            "givenName":"TEST INF age5",
                            "familyName":"FAMTEST AGE",
                            "age":"2"
                        }
                    ]
                }""";
        mockMvc.perform(post("/api/add_family").contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertEquals(result.getResponse().getContentAsString(),"Wrong family members data"));
    }

    @Test
    public void testPostSuccess() throws Exception{
        String content = """
                {
                    "familyDTO":{
                        "familyName":"FAMTEST AGE INF",
                        "nrOfAdults":"2",
                        "nrOfChildren":"1",
                        "nrOfInfants":"2"
                    },
                    "familyMemberDTOList":[
                        {
                            "givenName":"TEST INF age1",
                            "familyName":"FAMTEST AGE",
                            "age":"24"
                        },
                        {
                            "givenName":"TEST INF age2",
                            "familyName":"FAMTEST AGE",
                            "age":"25"
                        },
                        {
                            "givenName":"TEST INF age3",
                            "familyName":"FAMTEST AGE",
                            "age":"10"
                        },
                        {
                            "givenName":"TEST INF age4",
                            "familyName":"FAMTEST AGE",
                            "age":"3"
                        },
                        {
                            "givenName":"TEST INF age5",
                            "familyName":"FAMTEST AGE",
                            "age":"2"
                        }
                    ]
                }
                """;
        mockMvc.perform(post("/api/add_family").contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isAccepted())
                .andExpect(result -> assertEquals(result.getResponse().getContentAsString(),"Successfully created new family, id: "+repository.getMaxId()));
    }

}
