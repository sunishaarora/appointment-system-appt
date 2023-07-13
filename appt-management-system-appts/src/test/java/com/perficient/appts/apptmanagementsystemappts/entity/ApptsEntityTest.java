package com.perficient.appts.apptmanagementsystemappts.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ApptsEntityTest {
    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        Long userId = 2L;
        String apptName = "Test Appointment";
        String apptType = "Type 1";
        String description = "Test description";
        Date startTime = new Date();
        Date endTime = new Date();
        String metaData = "Test metadata";

        ApptsEntity apptEntity = new ApptsEntity();
        apptEntity.setId(id);
        apptEntity.setUserId(userId);
        apptEntity.setApptName(apptName);
        apptEntity.setApptType(apptType);
        apptEntity.setDescription(description);
        apptEntity.setStartTime(startTime);
        apptEntity.setEndTime(endTime);
        apptEntity.setMetaData(metaData);

        Assertions.assertEquals(id, apptEntity.getId());
        Assertions.assertEquals(userId, apptEntity.getUserId());
        Assertions.assertEquals(apptName, apptEntity.getApptName());
        Assertions.assertEquals(apptType, apptEntity.getApptType());
        Assertions.assertEquals(description, apptEntity.getDescription());
        Assertions.assertEquals(startTime, apptEntity.getStartTime());
        Assertions.assertEquals(endTime, apptEntity.getEndTime());
        Assertions.assertEquals(metaData, apptEntity.getMetaData());
    }

    @Test
    public void testEqualsAndHashCode() {
        ApptsEntity apptEntity1 = new ApptsEntity();
        apptEntity1.setId(1L);
        apptEntity1.setUserId(2L);

        ApptsEntity apptEntity2 = new ApptsEntity();
        apptEntity2.setId(1L);
        apptEntity2.setUserId(2L);

        ApptsEntity apptEntity3 = new ApptsEntity();
        apptEntity3.setId(2L);
        apptEntity3.setUserId(3L);

        Assertions.assertEquals(apptEntity1, apptEntity2);
        Assertions.assertNotEquals(apptEntity1, apptEntity3);
        Assertions.assertEquals(apptEntity1.hashCode(), apptEntity2.hashCode());
        Assertions.assertNotEquals(apptEntity1.hashCode(), apptEntity3.hashCode());
    }

    @Test
    public void testToString() {
        ApptsEntity apptEntity = new ApptsEntity();
        apptEntity.setId(1L);
        apptEntity.setUserId(2L);
        apptEntity.setApptName("Test Appointment");
        apptEntity.setApptType("Type 1");
        apptEntity.setDescription("Test description");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JULY, 13, 13, 56, 10);
        Date testDate = calendar.getTime();
        apptEntity.setStartTime(testDate);
        apptEntity.setEndTime(testDate);
        apptEntity.setMetaData("Test metadata");

        String expectedString = "ApptsEntity{id=1, userId=2, apptName='Test Appointment', apptType='Type 1', description='Test description', startTime=Thu Jul 13 13:56:10 CDT 2023, endTime=Thu Jul 13 13:56:10 CDT 2023, metaData='Test metadata'}";

        String actualString = apptEntity.toString();

        Assertions.assertEquals(expectedString, actualString);
        Assertions.assertEquals(1L, apptEntity.getId());
        Assertions.assertEquals(2L, apptEntity.getUserId());
        Assertions.assertEquals("Test Appointment", apptEntity.getApptName());
        Assertions.assertEquals("Type 1", apptEntity.getApptType());
        Assertions.assertEquals("Test description", apptEntity.getDescription());
        Assertions.assertEquals(testDate, apptEntity.getStartTime());
        Assertions.assertEquals(testDate, apptEntity.getEndTime());
        Assertions.assertEquals("Test metadata", apptEntity.getMetaData());
    }


}
