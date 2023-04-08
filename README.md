# Data Parsing Project
***

CRUD 기본 내용 정리 및 병의원 데이터 Parsing을 위한 프로젝트

- 병의원 데이터 출처 : https://www.localdata.go.kr/devcenter/dataDown.do?menuNo=20001

***

## CRUD Controller

[GetController](https://github.com/sandee-han/crud-parser-practice/blob/main/src/main/java/com/example/crudparser/controller/GetController.java)

- `RequestMethod.GET` 을 이용한 호출
- `@GetMapping` 을 이용한 호출
- `@PathVariable` 을 이용한 `{variable}` 호출
- `@RequestParam` 을 이용한 호출

[PostController](https://github.com/sandee-han/crud-parser-practice/blob/main/src/main/java/com/example/crudparser/controller/PostController.java)

- `RequestMethod.POST` 을 이용한 호출
- `@PostMapping` 을 이용한 호출
- `@RequestBody` 을 이용한 호출

[UserController](https://github.com/sandee-han/crud-parser-practice/blob/main/src/main/java/com/example/crudparser/controller/UserController.java)

JDBC를 이용한 sql문 호출

- `deleteAll` 호출로 User 데이터 전체 삭제
- `delete` 호출로 User 1개 삭제
- `add` 호출로 User 데이터 1개 입력
- `findById` 호출로 1개 데이터 검색

***

## Data Parsing

[ReadLineContext](https://github.com/sandee-han/crud-parser-practice/blob/main/src/main/java/com/example/crudparser/parser/ReadLineContext.java)

- `BufferedReader` 의 `readLine()` 을 이용해 파일 한줄씩 읽어오기

[HospitalParser](https://github.com/sandee-han/crud-parser-practice/blob/main/src/main/java/com/example/crudparser/parser/HospitalParser.java)

- 병의원 정보 중 필요 데이터를 추출

| **데이터 항목**| **데이터 명** |
|-------------------------|-----------|
| openServiceName         | 개방서비스명    |
| openLocalGovernmentCode | 개방자치단체코드  |
| managementNumber        | 관리번호      |
| licenseDate             | 인허가일자     |
| businessStatus          | 영업상태      |
| businessStatusCode      | 영업상태코드    |
| phone                   | 소재지 전화    |
| fullAddress             | 소재지 주소    |
| roadNameAddress         | 소재지 도로명 주소|
| hospitalName            | 병원명       |
| businessTypeName        | 업태구분명     |
| healthcareProviderCount | 의료인 수     |
| patientRoomCount        | 입원실 수     |
| totalNumberOfBeds       | 병상 수      |
| totalAreaSize           | 총 면적      |

[HospitalParserTest](https://github.com/sandee-han/crud-parser-practice/blob/main/src/test/java/com/example/crudparser/parser/HospitalParserTest.java)

- 테스트 코드를 통한 데이터 파싱
- 테스트 코드를 통한 데이터 insert