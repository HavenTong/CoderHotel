# CoderHotel

<div align="center"><img src="https://junit.org/junit4/images/junit5-banner.png" width="30%"></img></div>

## Requirement

作为一位酒店大堂服务人员，我想在大堂的城市时钟不准时，用设置自己手机时间的方法，自动统一调整这些城市时钟时间，来避免逐一根据时差调整这些时钟的繁琐工作，系统特性具体包括：

- REQ1

     ”码农酒店”大堂里有5个时钟，分别显示北京、伦敦、莫斯科、悉尼和纽约的时间

- REQ2:

    伦敦与UTC时间一致，北京比UTC时间早8小时，莫斯科比UTC时间早4小时，悉尼比UTC时间早10小时，纽约比UTC时间晚5小时

- REQ3

    将酒店大堂服务员的智能手机时间设置为北京时间

- REQ4

    若大堂墙壁上所有城市的时钟都或多或少有些走时不准，需要调整时间时，只需调准服务员手机的时间，那么墙上5个城市的时钟时间都能够相应地自动调整准确



## Develop

- macOS Mojave 10.14.6
- Java 11
- IDEA 2019.1 
- 程序入口在`HotelClocksSystemView.java`的`main`方法



## Test

- 使用Junit 5编写测试脚本
- 测试脚本位于`src/test`中
- 对`PhoneClock.java`, `HotelClocksSystem.java`, `HotelClocksSystemController.java`分别编写测试脚本: `PhoneClockTest.java`, `HotelClocksSystemTest.java`, `HotelClocksSystemControllerTest.java`
- 测试过程中发现的bug已在**issues**中说明
- 对`HotelClocksSystemView.java`没有编写测试脚本，而是采用手工测试的方式。具体情况请见**issues**