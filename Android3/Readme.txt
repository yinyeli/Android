Andorid 3 技术实现文档
成员：尹业立 16301054 陈建 16301031

1，视频播放：
访问tomcat服务器，接收视频文件
视频播放技术：VideoView

2,打电话：
Intent intent = new Intent(Intent.ACTION_DIAL);
intent.setData(Uri.parse("tel:" + phone));
//将意图传给操作系统，激活activity
startActivity(intent);

3，百度地图：使用LSB sdk
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;