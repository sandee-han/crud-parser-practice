package com.example.hello.parser;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.dto.Hospital;
import com.example.hello.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalParserTest {

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;
//
//    @Test
//    @DisplayName("Hostpital이 insert가 잘 되는지")
//    void addAndGet()  {
//        hospitalDao.deleteAll();
//        assertEquals(0, hospitalDao.getCount());
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//        hospitalDao.add(hospital);
//        assertEquals(1, hospitalDao.getCount());
//
//        Hospital selectedHospital = hospitalDao.findById(hospital.getId());
//        assertEquals(selectedHospital.getId(), hospital.getId());
//        assertEquals(selectedHospital.getOpenServiceName(), hospital.getOpenServiceName());
//
//        assertEquals(selectedHospital.getOpenLocalGovernmentCode(),hospital.getOpenLocalGovernmentCode());
//        assertEquals(selectedHospital.getManagementNumber(),hospital.getManagementNumber());
//        assertEquals(selectedHospital.getBusinessStatus(), hospital.getBusinessStatus()); // idx:7
//        assertEquals(selectedHospital.getBusinessStatusCode(), hospital.getBusinessStatusCode());
//
//        assertTrue(selectedHospital.getLicenseDate().isEqual(hospital.getLicenseDate()));
//
//        assertEquals(selectedHospital.getPhone(), hospital.getPhone());
//        assertEquals(selectedHospital.getFullAddress(), hospital.getFullAddress());
//        assertEquals(selectedHospital.getRoadNameAddress(), hospital.getRoadNameAddress());
//        assertEquals(selectedHospital.getHospitalName(), hospital.getHospitalName());
//        assertEquals(selectedHospital.getBusinessTypeName(), hospital.getBusinessTypeName());
//        assertEquals(selectedHospital.getHealthcareProviderCount(), hospital.getHealthcareProviderCount());
//        assertEquals(selectedHospital.getPatientRoomCount(), hospital.getPatientRoomCount());
//        assertEquals(selectedHospital.getTotalNumberOfBeds(), hospital.getTotalNumberOfBeds());
//        // 날짜, float
//        assertEquals(selectedHospital.getTotalAreaSize(), hospital.getTotalAreaSize());
//    }
//
//
//
//    @Test
//    void name() throws IOException {
//        // 테스트에서 이렇게 정보를 넣어버리면 서버 환경에서 build 시 문제가 생길 수 있음
//        String filename = "C:\\Users\\iwmis\\Downloads\\fulldata_01_01_02_P_의원.csv";
//        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
//        assertTrue(hospitalList.size() > 100000);
//    }
//
//
//
//    @Test
//    @DisplayName("10만건 이상 데이터가 파싱 되는지")
//    void oneHundredThousandRows() throws IOException {
//        // 서버환경에서 build할 때 문제가 생길 수 있습니다.
//        // 어디에서든지 실행할 수 있게 짜는 것이 목표.
//        hospitalDao.deleteAll();
//        String filename = "C:\\Users\\iwmis\\Downloads\\fulldata_01_01_02_P_의원.csv";
//        int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
//        assertTrue(cnt > 1000);
//        assertTrue(cnt > 10000);
//        System.out.printf("파싱된 데이터 개수:%d", cnt);
//    }
//
//
//    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
//    String line5 = "\"5\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100008\",\"19991221\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-573-8275\",\"\",\"500866\",\"광주광역시 북구 일곡동 850번지 3호 한국아파트상가2층\",\"광주광역시 북구 설죽로 565, 2층 (일곡동, 한국아파트상가)\",\"61036\",\"예일치과의원\",\"20211110105829\",\"U\",\"2021-11-12 02:40:00.0\",\"치과의원\",\"190524.80531\",\"190074.51546\",\"치과의원\",\"1\",\"0\",\"0\",\"125\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";

    @Test
    @DisplayName("csv 1줄을 Hospital로 잘 만드는지 테스트")
    void convertToHospital() {

        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);

        assertEquals(1, hospital.getId());  // col: 0
        assertEquals("의원", hospital.getOpenServiceName());  // col: 1
        assertEquals(3620000, hospital.getOpenLocalGovernmentCode());    // col: 2
        assertEquals("PHMA119993620020041100004", hospital.getManagementNumber());   //col: 4
        assertEquals(LocalDateTime.of(1999, 06, 12, 0, 0, 0), hospital.getLicenseDate()); // col: 5
        assertEquals(1, hospital.getBusinessStatus());  // col: 7
        assertEquals(13, hospital.getBusinessStatusCode()); // col: 9
        assertEquals("062-515-2875", hospital.getPhone());  // col: 15
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());    // col: 18
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());  // col: 19
        assertEquals("효치과의원", hospital.getHospitalName());  // col: 21
        assertEquals("치과의원", hospital.getBusinessTypeName());   // col: 25
        assertEquals(1, hospital.getHealthcareProviderCount()); // col: 30
        assertEquals(0, hospital.getPatientRoomCount());    // col: 31
        assertEquals(0, hospital.getTotalNumberOfBeds());   // col: 32
        assertEquals(52.29f, hospital.getTotalAreaSize());   // col: 33

    }
}
