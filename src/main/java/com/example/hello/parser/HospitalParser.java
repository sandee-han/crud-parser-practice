package com.example.hello.parser;

import com.example.hello.domain.dto.Hospital;
import io.swagger.models.auth.In;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String str) {
        // (1, hospital.getId());  // col: 0
        // ("의원", hospital.getOpenServiceName());  // col: 1
        // (3620000,hospital.getOpenLocalGovernmentCode());    // col: 3
        // ("PHMA119993620020041100004",hospital.getManagementNumber());   //col: 4
        // (19990612, hospital.getLicenseDate()); // col: 5
        // (6, hospital.getBusinessStatus());  // col: 7
        // (13, hospital.getBusinessStatusCode()); // col: 9
        // ("062-515-2875", hospital.getPhone());  // col: 15
        // ("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());    // col: 18
        // ("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());  // col: 19
        // ("효치과의원", hospital.getHospitalName());  // col: 21
        // ("치과의원", hospital.getBusinessTypeName());   // col: 25
        // (1, hospital.getHealthcareProviderCount()); // col: 30
        // (0, hospital.getPatientRoomCount());    // col: 31
        // (0, hospital.getTotalNumberOfBeds());   // col: 32
        // (52.29, hospital.getTotalAreaSize());   // col: 33
        String[] row = str.replace("\"", "").split(",");
        System.out.println(Arrays.toString(row));

        Hospital hospital = new Hospital();

        hospital.setId(Integer.parseInt(row[0].replace("\n", "")));
        hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[3]));
        hospital.setManagementNumber(row[4]);

        int year = Integer.parseInt(row[5].substring(0, 4));
        int month = Integer.parseInt(row[5].substring(4, 6));
        int day = Integer.parseInt(row[5].substring(6, 8));
        hospital.setLicenseDate(LocalDateTime.of(year, month, day, 0, 0, 0));

        hospital.setBusinessStatus(Integer.parseInt(row[7]));
        hospital.setBusinessStatusCode(Integer.parseInt(row[9]));
        hospital.setPhone(row[15]);
        hospital.setFullAddress(row[18]);
        hospital.setRoadNameAddress(row[19]);
        hospital.setHospitalName(row[21]);
        hospital.setBusinessTypeName(row[25]);
        hospital.setHealthcareProviderCount(Integer.parseInt(row[30]));
        hospital.setPatientRoomCount(Integer.parseInt(row[31]));
        hospital.setTotalNumberOfBeds(Integer.parseInt(row[32]));
        hospital.setTotalAreaSize(Integer.parseInt(row[33]));

        return new Hospital();
    }
}
