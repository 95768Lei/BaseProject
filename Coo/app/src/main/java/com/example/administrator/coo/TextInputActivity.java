package com.example.administrator.coo;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.coo.Base.BaseActivity;
import com.example.administrator.coo.Bean.IndexBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zhanglei
 * @date 17/03/20
 * 仿微博话题输入页
 */
public class TextInputActivity extends BaseActivity {

    @BindView(R.id.text_input_edit)
    EditText textInputEdit;
    @BindView(R.id.text_input_add_text)
    Button textInputAddText;

    private List<Integer> mList;
    private List<IndexBean> indexBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        ButterKnife.bind(this);
        initListener();
    }

    /**
     * 初始化监听事件
     */
    private void initListener() {
        textInputEdit.addTextChangedListener(new MyTextWatcher());
    }

    @OnClick({R.id.text_input_add_text, R.id.text_input_edit})
    public void onClick(View view) {
        switch (view.getId()) {
            //添加文字
            case R.id.text_input_add_text:
                addText();
                break;
            case R.id.text_input_edit:
                getAndSetIndex();
                break;
        }
    }

    /**
     * 获取edittext光标位置
     * 如果光标在蓝色字体内部，就将光标移动到蓝色字体的后方
     */
    private void getAndSetIndex() {
        if (indexBeanList != null && indexBeanList.size() > 0) {
            int selectionStart = textInputEdit.getSelectionStart() - 1;
            Log.e("getAndSetIndex", "selectionStart:" + selectionStart);
            //遍历集合查看光标是否在蓝色字体块中
            for (IndexBean bean : indexBeanList) {
                Log.e("getAndSetIndex", "getHeardIndex:" + bean.getHeardIndex() + "\ngetFooterIndex:" + bean.getFooterIndex());
                if (selectionStart >= bean.getHeardIndex() && selectionStart <= bean.getFooterIndex()) {
                    //条件成立，表示光标在蓝色字体块内，设置光标位置
                    textInputEdit.setSelection(bean.getFooterIndex());
                }
            }
        }
    }

    /**
     * 添加一段文字
     */
    private void addText() {
        String str = "#你是一个啥#";
        int heard;
        int footer;
        Spanned spanned = Html.fromHtml("<font color=\"blue\">" + str + "</font>");
        //添加文字
        textInputEdit.setText(textInputEdit.getText());
        heard = textInputEdit.getText().length();
        textInputEdit.append(spanned);
        footer = textInputEdit.getText().length();
        //设置光标位置
        textInputEdit.setSelection(textInputEdit.getText().toString().length());
        //记录蓝色字体块的头尾下标
        IndexBean bean = new IndexBean();
        bean.setHeardIndex(heard);
        bean.setFooterIndex(footer);
        bean.setLength(str.length());
        indexBeanList.add(bean);
    }

    /**
     * Edit录入的监听事件
     */
    public class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //记录两个#号的下标
            mList = new ArrayList<>();
            //表示是删除操作
            if (i1 == 1) {
                try {
                    //判断光标的前一位字符是不是#
                    String str = charSequence.toString();
                    String lastText = str.substring(i, i + 1);

                    //如果是，那么我们就要删除这个#号到下一个#号的之间的字符（包括#号）
                    if (lastText.equals("#")) {
                        String substring = str.substring(0, i + 1);
                        char[] chars = substring.toCharArray();
                        int count = 0;

                        if (mList != null) {
                            mList.clear();
                        }
                        //记录要删除内容的下标
                        int length = chars.length - 1;
                        for (int index = length; index >= 0; index--) {
                            if ((chars[index] + "").equals("#")) {
                                count++;
                                mList.add(index);
                                if (count == 2) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (NullPointerException e) {

                }
            }

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            //在这里执行删除的操作
            if (mList != null && mList.size() > 1) {
                Integer integer = mList.get(0);
                Integer integer1 = mList.get(1);
                editable.delete(integer1, integer);
                int index = 0;
                //删除的字符串长度
                int length = 0;
                //从蓝色块集合中删除
                if (indexBeanList != null && indexBeanList.size() > 0) {
                    for (int i = 0; i < indexBeanList.size(); i++) {
                        IndexBean bean = indexBeanList.get(i);
                        if (integer >= bean.getHeardIndex() && integer <= bean.getFooterIndex()) {
                            index = i;
                            length = bean.getLength();
                        }
                    }
                }
                indexBeanList.remove(index);
                //重新设置蓝色块下标集合
                for (int i = 0; i < indexBeanList.size(); i++) {
                    IndexBean bean = indexBeanList.get(i);
                    if (integer < bean.getHeardIndex()) {
                        bean.setHeardIndex(bean.getHeardIndex() - length);
                        bean.setFooterIndex(bean.getFooterIndex() - length);
                        indexBeanList.set(i, bean);
                    }
                }
            }
        }
    }
}
