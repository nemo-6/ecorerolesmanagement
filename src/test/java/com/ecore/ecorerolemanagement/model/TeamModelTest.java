package com.ecore.ecorerolemanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TeamModelTest {
    /**
     * Method under test: {@link TeamModel#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new TeamModel()).canEqual("Other"));
    }

    /**
     * Method under test: {@link TeamModel#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        // Arrange
        TeamModel teamModel = new TeamModel();

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertTrue(teamModel.canEqual(teamModel1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link TeamModel}
     *   <li>{@link TeamModel#setId(String)}
     *   <li>{@link TeamModel#setName(String)}
     *   <li>{@link TeamModel#setTeamLeadId(String)}
     *   <li>{@link TeamModel#setTeamMemberIds(List)}
     *   <li>{@link TeamModel#getId()}
     *   <li>{@link TeamModel#getName()}
     *   <li>{@link TeamModel#getTeamLeadId()}
     *   <li>{@link TeamModel#getTeamMemberIds()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        TeamModel actualTeamModel = new TeamModel();
        actualTeamModel.setId("42");
        actualTeamModel.setName("Name");
        actualTeamModel.setTeamLeadId("42");
        ArrayList<String> stringList = new ArrayList<>();
        actualTeamModel.setTeamMemberIds(stringList);

        // Assert
        assertEquals("42", actualTeamModel.getId());
        assertEquals("Name", actualTeamModel.getName());
        assertEquals("42", actualTeamModel.getTeamLeadId());
        assertSame(stringList, actualTeamModel.getTeamMemberIds());
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, null);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals2() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, "Different type to TeamModel");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamModel#equals(Object)}
     *   <li>{@link TeamModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertEquals(teamModel, teamModel);
        int expectedHashCodeResult = teamModel.hashCode();
        assertEquals(expectedHashCodeResult, teamModel.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamModel#equals(Object)}
     *   <li>{@link TeamModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertEquals(teamModel, teamModel1);
        int expectedHashCodeResult = teamModel.hashCode();
        assertEquals(expectedHashCodeResult, teamModel1.hashCode());
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("Name");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId(null);
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("42");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName(null);
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals9() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("Name");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals10() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId(null);
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Method under test: {@link TeamModel#equals(Object)}
     */
    @Test
    void testEquals11() {
        // Arrange
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");

        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(stringList);

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertNotEquals(teamModel, teamModel1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamModel#equals(Object)}
     *   <li>{@link TeamModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId(null);
        teamModel.setName("Name");
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId(null);
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertEquals(teamModel, teamModel1);
        int expectedHashCodeResult = teamModel.hashCode();
        assertEquals(expectedHashCodeResult, teamModel1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamModel#equals(Object)}
     *   <li>{@link TeamModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName(null);
        teamModel.setTeamLeadId("42");
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName(null);
        teamModel1.setTeamLeadId("42");
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertEquals(teamModel, teamModel1);
        int expectedHashCodeResult = teamModel.hashCode();
        assertEquals(expectedHashCodeResult, teamModel1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamModel#equals(Object)}
     *   <li>{@link TeamModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        // Arrange
        TeamModel teamModel = new TeamModel();
        teamModel.setId("42");
        teamModel.setName("Name");
        teamModel.setTeamLeadId(null);
        teamModel.setTeamMemberIds(new ArrayList<>());

        TeamModel teamModel1 = new TeamModel();
        teamModel1.setId("42");
        teamModel1.setName("Name");
        teamModel1.setTeamLeadId(null);
        teamModel1.setTeamMemberIds(new ArrayList<>());

        // Act and Assert
        assertEquals(teamModel, teamModel1);
        int expectedHashCodeResult = teamModel.hashCode();
        assertEquals(expectedHashCodeResult, teamModel1.hashCode());
    }
}

