package com.ecore.ecorerolemanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RoleModelTest {
    /**
     * Method under test: {@link RoleModel#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new RoleModel()).canEqual("Other"));
    }

    /**
     * Method under test: {@link RoleModel#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        // Arrange
        RoleModel roleModel = new RoleModel();

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertTrue(roleModel.canEqual(roleModel1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleModel}
     *   <li>{@link RoleModel#setId(String)}
     *   <li>{@link RoleModel#setName(String)}
     *   <li>{@link RoleModel#getId()}
     *   <li>{@link RoleModel#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        RoleModel actualRoleModel = new RoleModel();
        actualRoleModel.setId("42");
        actualRoleModel.setName("Name");

        // Assert
        assertEquals("42", actualRoleModel.getId());
        assertEquals("Name", actualRoleModel.getName());
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, null);
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals2() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, "Different type to RoleModel");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleModel#equals(Object)}
     *   <li>{@link RoleModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName("Name");

        // Act and Assert
        assertEquals(roleModel, roleModel);
        int expectedHashCodeResult = roleModel.hashCode();
        assertEquals(expectedHashCodeResult, roleModel.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleModel#equals(Object)}
     *   <li>{@link RoleModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName("Name");

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertEquals(roleModel, roleModel1);
        int expectedHashCodeResult = roleModel.hashCode();
        assertEquals(expectedHashCodeResult, roleModel1.hashCode());
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("Name");
        roleModel.setName("Name");

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, roleModel1);
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId(null);
        roleModel.setName("Name");

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, roleModel1);
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName("42");

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, roleModel1);
    }

    /**
     * Method under test: {@link RoleModel#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName(null);

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName("Name");

        // Act and Assert
        assertNotEquals(roleModel, roleModel1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleModel#equals(Object)}
     *   <li>{@link RoleModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId(null);
        roleModel.setName("Name");

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId(null);
        roleModel1.setName("Name");

        // Act and Assert
        assertEquals(roleModel, roleModel1);
        int expectedHashCodeResult = roleModel.hashCode();
        assertEquals(expectedHashCodeResult, roleModel1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleModel#equals(Object)}
     *   <li>{@link RoleModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        roleModel.setId("42");
        roleModel.setName(null);

        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId("42");
        roleModel1.setName(null);

        // Act and Assert
        assertEquals(roleModel, roleModel1);
        int expectedHashCodeResult = roleModel.hashCode();
        assertEquals(expectedHashCodeResult, roleModel1.hashCode());
    }
}

