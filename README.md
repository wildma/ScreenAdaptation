# 一种非常好用的 Android 屏幕适配——smallestWidth 限定符适配

### 优点

- 使用简单  
利用插件生成对应的 dimens.xml 文件，设计图标注多少 dp，布局中就写多少dp，格式为@dimen/dp_XX，sp 同理。

- 稳定性好  
smallestWidth 限定符适配方案很早就出现了，经过大量用户的验证，市面上的主流设备几乎都能精准适配。

- 对性能无影响  
适配原理是系统根据限定符去寻找对应的 dimens.xml 文件，并不影响程序的性能。

- 兼容性好  
smallestWidth 限定符适配寻找 dimens.xml 文件的原理是从大往小找，没有对应的则使用默认的，所以即使没有完全匹配也能达到不错的适配效果。

- 不影响第三方库  
需要适配的地方使用该种适配方案即可，不会影响到第三方库。

- 更换成本低  
该套适配方案采用的单位是 dp 和 sp，dp 和 sp 是 google 推荐使用的计量单位，即使以后不用该套适配方案，任然不影响现有的界面。


### 适配效果图
**Nexus S（320 dp）：**  

![Nexus S](https://github.com/wildma/ScreenAdaptation/blob/master/screenshots/Nexus%20S.jpg)

**Nexus 5（360 dp）：**  

![Nexus 5](https://github.com/wildma/ScreenAdaptation/blob/master/screenshots/Nexus%205.jpg)

**Nexus 4（384 dp）：**  

![Nexus 4](https://github.com/wildma/ScreenAdaptation/blob/master/screenshots/Nexus%204.jpg)

**Pixel XL（411.4285 dp）：**  

![Pixel XL](https://github.com/wildma/ScreenAdaptation/blob/master/screenshots/Pixel%20XL.jpg)


### 使用
详细介绍请看文章：[推荐一种非常好用的Android屏幕适配](https://www.jianshu.com/p/1302ad5a4b04)


ps：如果对你有帮助，点下star就是对我最大的认可。
