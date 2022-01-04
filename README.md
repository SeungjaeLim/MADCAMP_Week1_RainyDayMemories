
# 비 오는 날, 추억 한 꼬집 by 강준서, 임승재
> 갑자기 내리는 비를 소중한 추억으로
<img src="https://user-images.githubusercontent.com/74184274/148008895-5a1ff8ec-9dfa-4667-abbe-2a9ec57b6edf.png" width="300" height="300">

|오늘|연락처|추억|
|--|--|--|
|<img src="https://user-images.githubusercontent.com/74184274/148011164-2d5610b6-35ff-4d28-90e7-2ffe5bcf2859.jpg" width="225" height="400">|<img src="https://.jpg" width="190" height="400">|<img src = "https://user-images.githubusercontent.com/74184274/148010914-d404b7ce-ea9a-4edd-b6e2-18a01a7dce90.jpg" width = "225" height = "400">|

##  Splash
> 비 오는 날, 감성을 자극하는 인트로

  <img src="https://user-images.githubusercontent.com/74184274/148010894-8befce8b-a87e-42d1-b559-25e87e663ad4.jpg" width="225" height="400">
  
   - `SplashActivity.java`에서 `LottieAnimationView`를 이용하여 After Effect 애니메이션을 랜더링하여 `loading.json`을 보여줍니다.

##  Main
> 다양한 기능을 편하게 사용하기 위해 만든 스와이프 가능한 탭 구조

  <img src="https://user-images.githubusercontent.com/74184274/148017933-60d06651-20dc-404c-9957-f22b8f26c475.jpg" width="225" height="400">
  
   - `MainActivity.java`에서 `ViewPager`에 `TabLayout`을 적용하여 스와이프 가능한 탭 구조로 `Fragment`를 보여줍니다.

##  Tab1 : 오늘
> "나 지금 N1이야, 비오는데 데리러 와 줄 수 있어?" 

### 현 위치, 오늘 기온과 날씨
  
  <img src="https://user-images.githubusercontent.com/74184274/148011164-2d5610b6-35ff-4d28-90e7-2ffe5bcf2859.jpg" width="225" height="400"> 
  
  - 비오는 날 처음 보는 장소, 친구가 데리러 올 수 있는 장소를 지도에서 확인할 수 있습니다.
  - 날씨 확인을 통해 나가기 10분 전, 미리 데리러 오도록 연락할 수 있습니다.
  - 기온 확인을 통해 데리러 오는 친구에게 "오늘 춥다, 따뜻하게 입고 나와" 한마디 건네는건 어떨까요?
  
      - Google Maps API의 `MapView`를 이용해 지도를 보여줍니다.
      - `getLastLocation()`를 통해 현재 위치를 받아오고, 이를 지도에 표시합니다.
      - Geocoder를 이용하여 위도, 경도 값을 바탕으로 역지오코딩해 도시의 이름을 저장합니다.
      - OpenWeatherMap API에 역지오코딩 값을 이용해 현 위치의 날씨와 기온을 `json`으로 받아와 나타냅니다. 

## Tab2 : !
> !
> !
> ### !
  <img src = "https://.jpg" width = "190" height = "400" >
  
  - !
  - !
  - !
  - !
  - !

## Tab3 : 추억
> 비오는 날의 기억을 간직하고 싶은 추억으로 남기세요
### 사계절 앨범
  <img src = "https://user-images.githubusercontent.com/74184274/148010914-d404b7ce-ea9a-4edd-b6e2-18a01a7dce90.jpg" width = "225" height = "400">
  
  - 비오는 날의 풍경, 데리러 와준 고마운 사람과의 추억을 계절별로 정리하세요.
       - `GridLayout`에 `CardView`를 적용해 `SubActivity`를 호출하여 앨범을 구현하였습니다.

### 초기 화면
|Spring|Summer|Autumn|Winter|
|--|--|--|--|
|<img src="https://user-images.githubusercontent.com/74184274/148015534-bbdce00e-97cf-465a-b12d-9a4f1696fef7.jpg" width="225" height="400">|<img src="https://user-images.githubusercontent.com/74184274/148015535-b0aae00c-62f5-41d5-a782-e0ac29cbe6a7.jpg" width="225" height="400">|<img src = "https://user-images.githubusercontent.com/74184274/148015538-e097451b-3c09-47c5-a918-fd9685ed89fe.jpg" width = "225" height = "400">|<img src = "https://user-images.githubusercontent.com/74184274/148015536-f4027028-8a37-4573-afb3-faa4999ea962.jpg" width = "225" height = "400">|
   - 초기에는 아무 사진도 저장되어 있지 않습니다.
   - 추억 남기기 버튼을 이용해 갤러리에서 사진을 가져오는 화면으로 넘어가세요.
### 갤러리 사진 불러오기
  <img src = "https://user-images.githubusercontent.com/74184274/148010908-37a421cd-2c28-4335-9797-841c3d1363f3.jpg" width = "225" height = "400">
  
   - 사진을 선택해 1장에서 10장까지 불러오세요.
   - 기존 사진이 있을 경우 왼쪽으로 추가됩니다.
  
### 추억 저장
|Spring|Summer|Autumn|Winter|
|--|--|--|--|
|<img src="https://user-images.githubusercontent.com/74184274/148010910-40c96973-4f62-44bd-895e-d66222f59464.jpg" width="225" height="400">|<img src="https://user-images.githubusercontent.com/74184274/148010911-71ded0d9-ed1c-47b4-a76a-5a8341671362.jpg" width="225" height="400">|<img src = "https://user-images.githubusercontent.com/74184274/148010912-f44aa7df-ac52-418c-82c9-730b3bec9c56.jpg" width = "225" height = "400">|<img src = "https://user-images.githubusercontent.com/74184274/148010913-bdfd281b-5cff-4176-bc8c-8d017a6668ac.jpg" width = "225" height = "400">|
   - 추억이 남긴 사진을 스크롤하여 추억하세요.
   - 계절별로 사진을 저장해 추억할 수 있습니다.
  
  
##  Credit
  > Junseo Kang / 몰?루   
  > Seungjae Lim / seungjaelim@kaist.ac.kr


