package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Category;
import com.shxt.model.Estimate;
import com.shxt.model.Goods;
import com.shxt.util.JDBC_Tool;
/**
 * 商品控制器
 * @author 张国荣
 * @ClassName: GoodsService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:18:11
 * @description 类描述
 */
public class GoodsService {
	private String sql;
	private JDBC_Tool jt;
	private Goods g;
	private Category c;
	private List<Map<String,String>> temp;
	private List<Map<String,String>> temp2;
	public GoodsService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询商品类别信息
	 * @author 张国荣
	 * @title: selFirstClass
	 * @date 2016年8月14日 上午10:18:37
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selFirstClass(){
		sql = "SELECT id,kind FROM goods_category WHERE parent_id IS NULL ";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询小类别商品
	 * @author 张国荣
	 * @title: selMenu
	 * @date 2016年8月14日 上午10:18:58
	 * @param first_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selMenu(String first_id){
		sql = "SELECT g.id,g.goods_name,p.piece_name,g.post_price,g.discount,g.photo FROM goods g LEFT JOIN pieces p ON g.piece_id = p.id WHERE g.first_id = " + first_id + " LIMIT 0,5";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询小类别信息
	 * @author 张国荣
	 * @title: selSecondMenu
	 * @date 2016年8月14日 上午10:19:52
	 * @param first_id
	 * @return List<Category>
	 */
	public List<Category> selSecondMenu(String first_id){
		sql = "SELECT gc.id,gc.kind,COUNT(gc.id) number FROM goods_category gc JOIN goods g ON gc.id = g.second_id WHERE gc.parent_id = " + first_id + " GROUP BY gc.id";
		temp = jt.queryMap(sql, null);
		List<Category> secondMenu = new ArrayList<>();
		List<Goods> goods = new ArrayList<>();
		for(Map<String,String> e : temp){
			c = new Category();
			c.setId(Integer.parseInt(e.get("id")));
			c.setKind(e.get("kind"));
			c.setNumber(Integer.parseInt(e.get("number")));
			c.setParent_id(Integer.parseInt(first_id));
			sql = "SELECT id,goods_name,post_price,piece_id,discount,photo FROM goods WHERE second_id = "+ e.get("id");
			temp2 = jt.queryMap(sql, null);
			goods = new ArrayList<>();
			for(Map<String,String> e2 : temp2){
				g = new Goods();
				g.setDiscount(Double.parseDouble(e2.get("discount")));
				g.setGoods_name(e2.get("goods_name"));
				g.setId(Integer.parseInt(e2.get("id")));
				g.setPhoto(e2.get("photo"));
				g.setPiece_id(Integer.parseInt(e2.get("piece_id")));
				g.setPost_price(Double.parseDouble(e2.get("post_price")));
				goods.add(g);
			}
			c.setGoods(goods);
			secondMenu.add(c);
		}
		return secondMenu;
	}
	/**
	 * 查询商品信息
	 * @author 张国荣
	 * @title: selOneGoods
	 * @date 2016年8月14日 上午10:21:02
	 * @param id
	 * @return Goods
	 */
	public Goods selOneGoods(String id){
		sql = "SELECT g.id,g.first_id,g.second_id,g.goods_name,g.post_price,g.piece_id,g.discount,g.photo,og.number FROM goods g LEFT JOIN order_goods og ON g.id = og.goods_id WHERE g.id = " + id;
		Map<String,String> temp_map = jt.queryMap(sql, null).get(0);
		int number = 0;
		temp = jt.queryMap(sql, null);
		if(temp.get(0).get("number")!=null){
			for(Map<String,String> e : temp){
				number+=Integer.parseInt(e.get("number"));
			}
		}
		List<Estimate> temp = new EstimateService().selGoodsEstimate(id);
		int star = 0;
		if(!temp.isEmpty()){
			for(Estimate e:temp){
				star+=e.getStar();
			}
			star = (int)(star/temp.size());
		}
		g = new Goods();
		g.setStar(star);
		g.setSale_times(number);
		g.setDiscount(Double.parseDouble(temp_map.get("discount")));
		g.setFirst_id(Integer.parseInt(temp_map.get("first_id")));
		g.setGoods_name(temp_map.get("goods_name"));
		g.setId(Integer.parseInt(temp_map.get("id")));
		g.setPhoto(temp_map.get("photo"));
		g.setPiece_id(Integer.parseInt(temp_map.get("piece_id")));
		g.setPost_price(Double.parseDouble(temp_map.get("post_price")));
		g.setSecond_id(Integer.parseInt(temp_map.get("second_id")));
		return g;
	}
	/**
	 * 查询所有单位
	 * @author 张国荣
	 * @title: selPiece
	 * @date 2016年8月14日 上午10:21:15
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selPiece(){
		sql = "SELECT id,piece_name FROM pieces";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询评价商品
	 * @author 张国荣
	 * @title: selEstimateGoods
	 * @date 2016年8月14日 上午10:21:33
	 * @param order_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selEstimateGoods(String order_id){
		sql = "SELECT g.id,g.goods_name FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id WHERE og.order_id = " + order_id;
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询推荐商品
	 * @author 张国荣
	 * @title: selIntroduceGoods
	 * @date 2016年8月14日 上午10:22:59
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selIntroduceGoods(){
		sql = "SELECT g.id,g.goods_name,g.post_price,g.discount,i.description,g.photo FROM introduce i JOIN goods g ON i.goods_id = g.id";
		return jt.queryMap(sql, null);
	}
}
