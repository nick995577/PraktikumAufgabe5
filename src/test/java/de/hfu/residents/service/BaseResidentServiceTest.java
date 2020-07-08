package de.hfu.residents.service;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.*;
import java.util.*;

@RunWith( Parameterized.class)
public class BaseResidentServiceTest {
	
    private Resident resident1;
    private Resident resident2;
    private Resident resident3;


    private DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private ResidentRepositoryStub residentRepositoryStub;



    public BaseResidentServiceTest(String[] resident1, String[] resident2, String[] resident3) throws ParseException
    	{
    	
        this.resident1 = new Resident(resident1[0], resident1[1], resident1[2], resident1[3], format.parse(resident1[4]));
        this.resident2 = new Resident(resident2[0], resident2[1], resident2[2], resident2[3], format.parse(resident2[4]));
        this.resident3 = new Resident(resident3[0], resident3[1], resident3[2], resident3[3], format.parse(resident3[4]));
        List<Resident> residents = Arrays.asList(this.resident1, this.resident2, this.resident3);
        this.residentRepositoryStub = new ResidentRepositoryStub(residents);
    }

    @Parameterized.Parameters
    public static Collection daten() {
        return Arrays.asList(new String[][][] {
            {{"Bernd", "Nacht", "Gruennauer", "Geesthacht", "25-03-1976"},
            {"Kristian", "Hirsch", "Seeberger Str", "Seinsbach", "02-02-1988"},
            {"Nadine", "Dietrich", "Birkenheide", "Hermmannstal", "22-09-1973"}}
        });
    }

    
    @Test
    public void testGetUniqueResident1() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Bernd", "Nacht", "Gruennauer", "Geesthacht", format.parse("25-03-1976"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    

    @Test
    public void testGetUniqueResident2() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Kristian", "Hirsch", "Seeberger Str", "Seinsbach", format.parse("02-02-1988"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    @Test
    public void testGetUniqueResident3() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Nadine", "Dietrich", "Birkenheide", "Hermmannstal", format.parse("22-09-1973"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    

    @Test
    public void testGetFilteredResidentsList1() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Nacht", "", "", null);
        Assert.assertEquals(Arrays.asList(resident1), baseResidentService.getFilteredResidentsList(resident));
    }

    
    @Test
    public void testGetFilteredResidentsList2() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Hirsch", "", "", null);
        Assert.assertEquals(Arrays.asList(resident2), baseResidentService.getFilteredResidentsList(resident));
    }
  
    
    
    @Test
    public void testGetFilteredResidentsList3() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Dietrich", "", "Hermmanstal", null);
        Assert.assertEquals(Arrays.asList(resident3), baseResidentService.getFilteredResidentsList(resident));
    }
    
} 