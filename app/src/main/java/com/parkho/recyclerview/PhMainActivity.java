package com.parkho.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhMainActivity extends AppCompatActivity {

    // List item
    private List<PhRecyclerItem> mItemList = new ArrayList<>();

    // Recycler view adapter
    private PhRecyclerViewAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List 설정
        bindList();

        // 삽입 설정
        bindInsert();

        // 수정 설정
        bindModify();

        // 삭제 설정
        bindDelete();
    }

    /**
     * List 설정
     */
    private void bindList() {
        // List item 생성

        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f600, "emoji_u1f600"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f601, "emoji_u1f601"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f602, "emoji_u1f602"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f603, "emoji_u1f603"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f604, "emoji_u1f604"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f605, "emoji_u1f605"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f606, "emoji_u1f606"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f607, "emoji_u1f607"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f608, "emoji_u1f608"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f609, "emoji_u1f609"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f610, "emoji_u1f610"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f611, "emoji_u1f611"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f612, "emoji_u1f612"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f613, "emoji_u1f613"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f614, "emoji_u1f614"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f615, "emoji_u1f615"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f616, "emoji_u1f616"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f617, "emoji_u1f617"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f618, "emoji_u1f618"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f619, "emoji_u1f619"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f620, "emoji_u1f620"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f621, "emoji_u1f621"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f622, "emoji_u1f622"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f623, "emoji_u1f623"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f624, "emoji_u1f624"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f625, "emoji_u1f625"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f626, "emoji_u1f626"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f627, "emoji_u1f627"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f628, "emoji_u1f628"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f629, "emoji_u1f629"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f630, "emoji_u1f630"));
        mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f631, "emoji_u1f631"));

        // Recycler view
        RecyclerView rcyclerView = findViewById(R.id.recycler_view);

        // Adapter 설정
        mRecyclerAdapter = new PhRecyclerViewAdapter(mItemList);
        rcyclerView.setAdapter(mRecyclerAdapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcyclerView.setLayoutManager(layoutManager);
    }

    /**
     * 삽입 설정
     */
    private void bindInsert() {
        findViewById(R.id.btn_insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Item 추가
                mItemList.add(new PhRecyclerItem(R.drawable.emoji_u1f605, "emoji_u1f605 " + mItemList.size()));

                // List 반영
                // mRecyclerAdapter.notifyDataSetChanged();
                mRecyclerAdapter.notifyItemInserted(mItemList.size());
            }
        });
    }

    /**
     * 수정 설정
     */
    private void bindModify() {
        findViewById(R.id.btn_modify).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final PhRecyclerItem recyclerItem = mRecyclerAdapter.getSelected();
                if (recyclerItem == null) {
                    Toast.makeText(PhMainActivity.this, R.string.err_no_selected_item, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Recycler item 수정
                recyclerItem.setName(recyclerItem.getName() + " is modified");

                // List 반영
                // mRecyclerAdapter.notifyDataSetChanged();
                final int checkedPosition = mRecyclerAdapter.getCheckedPosition();
                mRecyclerAdapter.notifyItemChanged(checkedPosition);

                // 선택 항목 초기화
                mRecyclerAdapter.clearSelected();
            }
        });
    }

    /**
     * 삭제 설정
     */
    private void bindDelete() {
        findViewById(R.id.btn_delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final PhRecyclerItem recyclerItem = mRecyclerAdapter.getSelected();
                if (recyclerItem == null) {
                    Toast.makeText(PhMainActivity.this, R.string.err_no_selected_item, Toast.LENGTH_SHORT).show();
                    return;
                }

                // 선택한 item 삭제
                mItemList.remove(recyclerItem);

                // List 반영
                // mRecyclerAdapter.notifyDataSetChanged();
                final int checkedPosition = mRecyclerAdapter.getCheckedPosition();
                mRecyclerAdapter.notifyItemRemoved(checkedPosition);

                // 선택 항목 초기화
                mRecyclerAdapter.clearSelected();
            }
        });
    }
}