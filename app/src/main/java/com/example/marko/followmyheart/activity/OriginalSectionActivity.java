package com.example.marko.followmyheart.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marko.followmyheart.MyApp;
import com.example.marko.followmyheart.R;
import com.example.marko.followmyheart.adapter.originalsection.OriginalSectionAdapter;
import com.example.marko.followmyheart.adapter.section.SectionBean;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OriginalSectionActivity extends MyApp implements OriginalSectionAdapter.OnItemClickListener {

    @BindView(R.id.rv_original_section)
    RecyclerView rvOriginalSection;
    private OriginalSectionAdapter adapter;
    private List<SectionBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_section);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvOriginalSection.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new OriginalSectionAdapter(this, getData());
        rvOriginalSection.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    private List<SectionBean> getData() {
        datas = new ArrayList<>();
        datas.add(new SectionBean(R.drawable.student, "学生卡"));
        datas.add(new SectionBean(R.drawable.recharge, "深圳通卡充值"));
        datas.add(new SectionBean(R.drawable.balance, "卡余额查询"));
        datas.add(new SectionBean(R.drawable.icon_diy, "DIY卡"));
        datas.add(new SectionBean(R.drawable.card_shop, "普卡商城"));
        datas.add(new SectionBean(R.drawable.invoice, "电子发票"));
        datas.add(new SectionBean(R.drawable.subway, "地铁查询"));
        datas.add(new SectionBean(R.drawable.icon_duijiang, "兑券中心"));
        datas.add(new SectionBean(R.drawable.icon_duijiang, "兑券中心"));
        datas.add(new SectionBean(R.drawable.icon_duijiang, "兑券中心"));
        return datas;
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                //带输入框的对话框
                showEditTextDialog(position);
                break;
            case 1:
                //消息类型对话框（蓝色按钮）
                showMessagePositiveDialog(position);
                break;
            case 2:
                //消息类型对话框（红色按钮）
                showMessageNegativeDialog(position);
                break;
            case 3:
                //消息类型对话框 (很长文案)
                showLongMessageDialog(position);
                break;
            case 4:
                //菜单类型对话框
                showMenuDialog();
                break;
            case 5:
                //带 Checkbox 的消息确认框
                showConfirmMessageDialog();
                break;
            case 6:
                //单选菜单类型对话框
                showSingleChoiceDialog();
                break;
            case 7:
                //多选菜单类型对话框
                showMultiChoiceDialog();
                break;
            case 8:
                //多选菜单类型对话框(item 数量很多)
                showNumerousMultiChoiceDialog();
                break;
            case 9:
                //高度适应键盘升降的对话框
                showAutoDialog();
                break;
            default:
                break;

        }

    }

    private void showEditTextDialog(int position) {
        QMUIDialog.EditTextDialogBuilder dialogBuilder = new QMUIDialog.EditTextDialogBuilder(this);
        dialogBuilder.setTitle("来了老妹儿！" + datas.get(position).getTv_icon())
                .setPlaceholder("请输入我爱你")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("确定", (dialog, index) -> dialog.dismiss())
                .create().show();
    }

    private void showMessagePositiveDialog(int position) {
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("来了老妹儿！" + datas.get(position).getTv_icon())
                .setMessage("确定你爱我吗？")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("确定", (dialog, index) -> {
                    dialog.dismiss();
                    Toast.makeText(OriginalSectionActivity.this, "爱你哟", Toast.LENGTH_SHORT).show();
                })
                .create().show();
    }

    private void showMessageNegativeDialog(int position) {
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("来了老妹儿！" + datas.get(position).getTv_icon())
                .setMessage("确定要删除吗？")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction(0, "删除", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        Toast.makeText(OriginalSectionActivity.this, "妈耶，删除成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create().show();
    }

    private void showLongMessageDialog(int position) {
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("来了老妹儿" + datas.get(position).getTv_icon())
                .setMessage("曾经有一份真诚的爱情摆在我的面前，但是我没有珍惜，" +
                        "等到了失去的时候才后悔莫及，尘世间最痛苦的事莫过于此。" +
                        "如果上天可以给我一个机会，再来一次的话，我会跟那个女孩说我爱她！" +
                        "如果非要把这份爱加上一个期限，我希望是···一万年！")
                .addAction("你可拉倒吧", (dialog, index) -> dialog.dismiss())
                .create().show();
    }

    private void showMenuDialog() {
        final String[] items = new String[]{
                "本是青灯不归客",
                "却因浊酒恋红尘",
                "星空不问赶路人",
                "岁月不负有心人"};
        new QMUIDialog.MenuDialogBuilder(OriginalSectionActivity.this)
                .addItems(items, (dialog, which) -> {
                    Toast.makeText(OriginalSectionActivity.this, "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .create().show();
    }

    private void showConfirmMessageDialog() {
        new QMUIDialog.CheckBoxMessageDialogBuilder(this)
                .setTitle("退出后是否删除账号信息?")
                .setMessage("删除账号信息")
                .setChecked(true)
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("退出", (dialog, index) -> dialog.dismiss())
                .create().show();
    }

    private void showSingleChoiceDialog() {
        final String[] items = new String[]{"木马牛", "梅子酒", "绣冬 春雷", "刹那枪"};
        final int checkedIndex = 1;
        new QMUIDialog.CheckableDialogBuilder(OriginalSectionActivity.this)
                .setCheckedIndex(checkedIndex)
                .addItems(items, (dialog, which) -> {
                    Toast.makeText(OriginalSectionActivity.this, "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .create().show();
    }

    private void showMultiChoiceDialog() {
        final String[] items = new String[]{"独孤九剑", "乾坤大挪移", "九阳神功", "降龙十八掌", "佛怒火连", "大荒囚天指", "大浮屠决"};
        final QMUIDialog.MultiCheckableDialogBuilder builder = new QMUIDialog.MultiCheckableDialogBuilder(this)
                .setCheckedItems(new int[]{1, 3})
                .addItems(items, (dialog, which) -> {

                });
        builder.addAction("取消", (dialog, index) -> dialog.dismiss());
        builder.addAction("提交", (dialog, index) -> {
            String result = "你选择了 ";
            for (int i = 0; i < builder.getCheckedItemIndexes().length; i++) {
                result += "" + builder.getCheckedItemIndexes()[i] + "; ";
            }
            Toast.makeText(OriginalSectionActivity.this, result, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.create().show();
    }

    private void showNumerousMultiChoiceDialog() {
        final String[] items = new String[]{
                "天问", "渊红", "太阿", "干将莫邪", "雪霁",
                "水寒", "秋骊", "凌虚", "巨阙", "虎魄", "天照",
                "含光", "湛卢", "逆鳞", "墨眉", "鲨齿", "越王八剑"
        };
        final QMUIDialog.MultiCheckableDialogBuilder builder = new QMUIDialog.MultiCheckableDialogBuilder(OriginalSectionActivity.this)
                .setCheckedItems(new int[]{1, 3})
                .addItems(items, (dialog, which) -> {

                });
        builder.addAction("取消", (dialog, index) -> dialog.dismiss());
        builder.addAction("提交", (dialog, index) -> {
            String result = "你选择了 ";
            for (int i = 0; i < builder.getCheckedItemIndexes().length; i++) {
                result += "" + builder.getCheckedItemIndexes()[i] + "; ";
            }
            Toast.makeText(OriginalSectionActivity.this, result, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.create().show();
    }

    private void showAutoDialog() {
        QMAutoTestDialogBuilder autoTestDialogBuilder = (QMAutoTestDialogBuilder) new QMAutoTestDialogBuilder(OriginalSectionActivity.this)
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("确定", (dialog, index) -> {
                    Toast.makeText(OriginalSectionActivity.this, "你点了确定", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });
        autoTestDialogBuilder.create().show();
        QMUIKeyboardHelper.showKeyboard(autoTestDialogBuilder.getEditText(), true);
    }

    class QMAutoTestDialogBuilder extends QMUIDialog.AutoResizeDialogBuilder {
        private Context mContext;
        private EditText mEditText;

        public QMAutoTestDialogBuilder(Context context) {
            super(context);
            mContext = context;
        }

        public EditText getEditText() {
            return mEditText;
        }

        @Override
        public View onBuildContent(QMUIDialog dialog, ScrollView parent) {
            LinearLayout layout = new LinearLayout(mContext);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            int padding = QMUIDisplayHelper.dp2px(mContext, 20);
            layout.setPadding(padding, padding, padding, padding);
            mEditText = new AppCompatEditText(mContext);
            QMUIViewHelper.setBackgroundKeepingPadding(mEditText, QMUIResHelper.getAttrDrawable(mContext, R.attr.qmui_list_item_bg_with_border_bottom));
            mEditText.setHint("输入框");
            LinearLayout.LayoutParams editTextLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, QMUIDisplayHelper.dpToPx(50));
            editTextLP.bottomMargin = QMUIDisplayHelper.dp2px(OriginalSectionActivity.this, 15);
            mEditText.setLayoutParams(editTextLP);
            layout.addView(mEditText);
            TextView textView = new TextView(mContext);
            textView.setLineSpacing(QMUIDisplayHelper.dp2px(OriginalSectionActivity.this, 4), 1.0f);
            textView.setText("观察聚焦输入框后，键盘升起降下时 dialog 的高度自适应变化。\n\n" +
                    "QMUI Android 的设计目的是用于辅助快速搭建一个具备基本设计还原效果的 Android 项目，" +
                    "同时利用自身提供的丰富控件及兼容处理，让开发者能专注于业务需求而无需耗费精力在基础代码的设计上。" +
                    "不管是新项目的创建，或是已有项目的维护，均可使开发效率和项目质量得到大幅度提升。");
            textView.setTextColor(ContextCompat.getColor(OriginalSectionActivity.this, R.color.app_color_description));
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(textView);
            return layout;
        }
    }
}
