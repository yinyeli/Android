Andorid 3 ����ʵ���ĵ�
��Ա����ҵ�� 16301054 �½� 16301031

1����Ƶ���ţ�
����tomcat��������������Ƶ�ļ�
��Ƶ���ż�����VideoView

2,��绰��
Intent intent = new Intent(Intent.ACTION_DIAL);
intent.setData(Uri.parse("tel:" + phone));
//����ͼ��������ϵͳ������activity
startActivity(intent);

3���ٶȵ�ͼ��ʹ��LSB sdk
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