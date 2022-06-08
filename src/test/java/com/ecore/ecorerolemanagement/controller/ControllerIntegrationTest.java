//package com.ecore.ecorerolemanagement.controller;
//
//import com.ecore.ecorerolemanagement.EcorerolemanagementApplication;
//import com.ecore.ecorerolemanagement.configuration.EmbeddedMongoTestConfiguration;
//import com.ecore.ecorerolemanagement.model.MembershipModel;
//import com.ecore.ecorerolemanagement.model.RoleModel;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        classes = EcorerolemanagementApplication.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
//@ContextConfiguration()
//public class ControllerIntegrationTest {
//
//    @LocalServerPort
//    private int port;
//
//    TestRestTemplate restTemplate = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//
//    @Test
//    public void testInsertAndGetRoles() {
//        RoleModel roleDev = new RoleModel();
//        RoleModel roleTester = new RoleModel();
//        RoleModel rolePO = new RoleModel();
//        roleDev.setName("Developer");
//        roleDev.setName("Tester");
//        roleDev.setName("Product Owner");
//        ArrayList<RoleModel> modelList = new ArrayList<>();
//        modelList.add(roleDev);
//        modelList.add(rolePO);
//        modelList.add(roleTester);
//
//        HttpEntity<ArrayList<RoleModel>> entity = new HttpEntity<ArrayList<RoleModel>>(modelList, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/roles"),
//                HttpMethod.POST, entity, String.class);
//
//        HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response2 = restTemplate.exchange(
//                createURLWithPort("/roles"),
//                HttpMethod.GET, entity, String.class);
//
//        assertTrue(response.getBody().contains("Developer"));
//        assertTrue(response.getBody().contains("Tester"));
//        assertTrue(response.getBody().contains("Product Owner"));
//    }
//
//    @Test
//    public void testInsertAndFindMemberships() {
//        // Create Memberships
//        ArrayList<MembershipModel> modelList = new ArrayList<>();
//        MembershipModel membership1 = new MembershipModel("1","1", "1", "Developer");
//        MembershipModel membership2 = new MembershipModel("2","2", "2", "Tester");
//        MembershipModel membership3 = new MembershipModel("3","3", "3", "Product Owner");
//        modelList.add(membership1);
//        modelList.add(membership2);
//        modelList.add(membership3);
//        var entity = new HttpEntity<>(modelList, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/roles"),
//                HttpMethod.POST, entity, String.class);
//
//        // Get memberships by Role
//        HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response2 = restTemplate.exchange(
//                createURLWithPort("/memberships?roleName=Developer"),
//                HttpMethod.GET, entity2, String.class
//        );
//        assertTrue(response2.getBody().contains("Developer"));
//
//        HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response3 = restTemplate.exchange(
//                createURLWithPort("/memberships?roleName=Tester"),
//                HttpMethod.GET, entity3, String.class
//        );
//        assertTrue(response3.getBody().contains("Tester"));
//
//        // Get Role for Membership
//        HttpEntity<String> entity4 = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response4 = restTemplate.exchange(
//                createURLWithPort("/memberships?memberId=2&teamId=2"),
//                HttpMethod.POST, entity4, String.class
//        );
//        assertTrue(response4.getBody().contains("Tester"));
//    }
//
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//
//}
