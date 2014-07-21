package com.socialmap.yy.travelbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.socialmap.yy.travelbox.R;
import com.socialmap.yy.travelbox.model.TravelSchedule;

import java.util.LinkedList;
import java.util.List;

public class ScheduleActivity extends Activity {

    static final String[] days = {
            "第一天", "第二天", "第三天", "第四天", "第五天", "第六天", "第七天"
    };

    static List<TravelSchedule> schedules;

    static {
        schedules = new LinkedList<>();
        schedules.add(new TravelSchedule(
                "第1天：长沙",
                "游览湖南省会、历史文化名城长沙——湖南省博物馆：马王堆汉墓陈列，岳麓山爱晚亭，长沙古城标志：天心阁，世界最大的内陆洲、潇湘八景之一的——橘子洲，参观巨型毛泽东塑像，感受毛泽东《沁园春.长沙》诗句的豪迈气概"
        ));
        schedules.add(new TravelSchedule(
                "第2天：花明楼、韶山",
                "参观刘少奇的故里——花明楼，刘少奇纪念馆、故居、铜像广场，之后乘车赴毛泽东的家乡——韶山：参观毛主席故居、怀念馆、铜像广场，感受一代伟人情怀，乘车赴张家界"
        ));
        schedules.add(new TravelSchedule(
                "第3天：袁家界、天子山",
                "自水绕四门乘世界最高的户外观光电梯上山，观神兵聚会绝景，游览武陵源的核心——袁家界，袁家界为一方山台地，纵目远望，奇峰尽收眼底，蔚为壮观，主要景点有：后花园、迷魂台、《阿凡达》电影中美轮美奂的悬浮山原型之乾坤柱、天下第一桥等绝世景观。乘环保车赴世界砂岩峰林之冠天子山，天子山海拔1262.5米，有“扩大的盆景，缩小的仙境”之美誉，是张家界砂岩峰林最为集中之处，气势宏大，场面壮观，主要景点有仙女献花、西海、云青岩、御笔峰、贺龙公园、武士驯马等，下山后游览“人行其间，宛如画图中”的十里画廊等自然景观"
        ));
        schedules.add(new TravelSchedule(
                "第4天：金鞭溪、黄石寨",
                "游览水绕四门，张家界国家森林公园——绝美大峡谷：金鞭溪，金鞭溪全长7.5公里，尤如一条玉带，穿行于深壑幽谷中间，两岸奇峰耸立，直插云天，树木繁茂，浓荫蔽日，溪水潺潺，琉璃飞瀑，被称为“世界最美的峡谷”、“最富有诗意的溪流”，主要景点有：闺门倒影、金鞭岩、劈刀救母、帅徒取经、双龟探溪、紫草潭、跳鱼潭、千里相会、重欢树等自然景观。游览黄石寨，黄石寨海拔1080 米，四周绝崖峭壁，是高旷的凌空观景台，主要景点有双门迎宾、雾海金龟、天桥遗墩、六奇阁、摘星台、五指峰等自然景观，结束愉快的旅程。 "
        ));
    }

    private ListView leftDrawer;

    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        leftDrawer = (ListView) findViewById(R.id.tb_schedule_left_drawer);
        leftDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_schedule_drawer_item, days));

        list = (ListView)findViewById(R.id.tb_schedule_list);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
