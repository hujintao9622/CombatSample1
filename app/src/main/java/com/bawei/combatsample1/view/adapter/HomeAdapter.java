package com.bawei.combatsample1.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.combatsample1.R;
import com.bawei.combatsample1.model.bean.LawyerBean;
import com.bawei.combatsample1.util.NetUtils;

import java.util.List;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/1 0001 下午 7:32
 */
public class HomeAdapter extends BaseAdapter {
    private List<LawyerBean.ListdataBean> list;

    public HomeAdapter(List<LawyerBean.ListdataBean> listdata) {

        this.list= listdata;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(parent.getContext(), R.layout.homeitem,null);
            holder.img=convertView.findViewById(R.id.it_img);
            holder.name=convertView.findViewById(R.id.it_name);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        LawyerBean.ListdataBean listdataBean = list.get(position);
        holder.name.setText(listdataBean.getName());
        String avatar = listdataBean.getAvatar();
        NetUtils.getInstance().getBitmap(avatar,holder.img);
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView name;
    }
}
