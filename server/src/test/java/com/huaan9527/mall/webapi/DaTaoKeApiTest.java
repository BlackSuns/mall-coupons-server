package com.huaan9527.mall.webapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaan9527.mall.webapi.configuration.properties.DaTaoKeProperties;
import com.huaan9527.mall.webapi.service.operation.api.AlbumApi;
import com.huaan9527.mall.webapi.service.operation.api.ExplosiveGoodsListApi;
import com.huaan9527.mall.webapi.service.operation.api.GoodsApi;
import com.huaan9527.mall.webapi.service.operation.api.GoodsDetailApi;
import com.huaan9527.mall.webapi.service.operation.api.HotSearchTop10Api;
import com.huaan9527.mall.webapi.service.operation.api.PrivilegeApi;
import com.huaan9527.mall.webapi.service.operation.api.SearchApi;
import com.huaan9527.mall.webapi.service.operation.api.SimilarGoodsApi;
import com.huaan9527.mall.webapi.service.operation.api.TaobaoSearchApi;
import com.huaan9527.mall.webapi.utils.HttpsClientUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DaTaoKeApiTest extends BaseTest {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ExplosiveGoodsListApi explosiveGoodsListApi;
    @Autowired
    private TaobaoSearchApi taobaoSearchApi;

    @Test
    public void test1() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        AlbumApi albumApi = new AlbumApi(properties);
        System.out.println(albumApi.loadAlbum());
    }

    @Test
    public void test2() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        GoodsApi goodsApi = new GoodsApi(properties);
        Map<String, String> params = new HashMap<>();
        params.put("pageId", "1");
        params.put("pageSize", "50");
        JSONObject result = goodsApi.loadGoods(params);
        System.out.println(result);
        System.out.println(result.getJSONArray("list").size());
    }

    @Test
    public void test3() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        PrivilegeApi privilegeApi = new PrivilegeApi(properties);
        JSONObject result = privilegeApi.getPrivilegeLink("574092314700");
        System.out.println(result);
    }


    @Test
    public void test4() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        HotSearchTop10Api searchApi = new HotSearchTop10Api(properties);
        System.out.println(JSON.toJSONString(searchApi.loadHotSearch()));
    }


    @Test
    public void test5() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        SearchApi searchApi = new SearchApi(properties);
        System.out.println(JSON.toJSONString(searchApi.search("男鞋", 1, 0)));
    }


    @Test
    public void test6() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        SimilarGoodsApi similarGoodsApi = new SimilarGoodsApi(properties);
        System.out.println(JSON.toJSONString(similarGoodsApi.loadSimilarGoods("25484224", 10)));
    }


    @Test
    public void test7() {
    }

    @Test
    public void test8() {
        DaTaoKeProperties properties = new DaTaoKeProperties();
        properties.setAppKey("5e567e7e64c23");
        properties.setAppSecret("f188932996748f8d6717ec85fc0f76be");

        GoodsDetailApi detailApi = new GoodsDetailApi(properties);
        System.out.println(JSON.toJSONString(detailApi.loadGoodsDetail(null, "624807922947")));
    }


    @Test
    public void test9() {
//        String url = "https://api.nothing.la/nothing/wechat/item/common/matchList.do?accessToken=7e57ae61b3274512a596714f5cba6e13";
//        String parameter = "{\"limit\": 16,\"startRow\": 0}";
        String url = "https://api.nothing.la/nothing/wechat/match/common/matchDetail.do?accessToken=7e57ae61b3274512a596714f5cba6e13";
        String parameter = "{\"matchId\": \"a3d1eef0379845b680ecb7007ac48a93\"}";
        String body = HttpsClientUtil.doPost(url, parameter);
        System.out.println(body);
    }

    @Test
    public void test10() {
        Sort sort = new Sort(Sort.Direction.DESC, "created_date");
        Iterator<Sort.Order> iterator = sort.iterator();
        while (iterator.hasNext()) {
            Sort.Order order = iterator.next();
            System.out.println(JSON.toJSONString(order));
        }
    }


    @Test
    public void test11() throws ParseException {
        PrettyTime prettyTime = new PrettyTime(new Date());
        String format = prettyTime.format(DateUtils.parseDate("2020-04-30 13:00:00", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
    }

    @Test
    public void test14() {
    }

    @Test
    public void test15() {
        String url = "http://api.yyixxx.com/api/discovery/match?device=1&limit=20&page=1&type=0";
        String body = HttpsClientUtil.doPost(url, "");
        System.out.println(body);
    }

    @Test
    public void test17() {
        String body = restTemplate.getForObject("https://m.tb.cn/h.4aN7Uzr?sm=07929b", String.class);
    }

    @Test
    public void test18() {
        Map<String, String> params = new HashMap<>();
        params.put("pageId", "1");
        params.put("pageSize", "10");
        JSONObject jsonObject = explosiveGoodsListApi.get(params);
        System.out.println(jsonObject);
    }

    @Test
    public void test19() {
        JSONArray array = taobaoSearchApi.search("电饭锅", 1, "tk_total_sales_des", "true");
        System.out.println(array);
    }


}
