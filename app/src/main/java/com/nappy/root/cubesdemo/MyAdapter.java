package com.nappy.root.cubesdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

/**
 * Created by root on 11/18/16.
 */

public class MyAdapter extends RecyclerSwipeAdapter<MyAdapter.SimpleViewHolder> {

    private Context context;
    private List<Transaction> listItems;

    public MyAdapter(Context context, List<Transaction> objects) {
        this.context = context;
        this.listItems = objects;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        return new SimpleViewHolder(view);    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        final Transaction item = listItems.get(position);
        viewHolder.amount.setText(item.getAmount());
        viewHolder.message.setText(item.getMessage());
        viewHolder.status.setText(item.getStatus());
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
//                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        viewHolder.swipeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog); //layout for dialog
                dialog.setTitle(item.getReason());
                dialog.setCancelable(true); //none-dismiss when touching outside Dialog

                TextView amount = (TextView) dialog.findViewById(R.id.amount);
                TextView type = (TextView) dialog.findViewById(R.id.type);
                TextView from = (TextView) dialog.findViewById(R.id.from);
                TextView reason = (TextView) dialog.findViewById(R.id.reason);
                TextView status = (TextView) dialog.findViewById(R.id.status);
                TextView trans = (TextView) dialog.findViewById(R.id.tran);

                amount.setText(item.getAmount());
                type.setText(item.getType());
                from.setText(item.getFrom());
                reason.setText(item.getReason());
                status.setText(item.getStatus());
                trans.setText(item.getId());

                dialog.show();
                return false;
            }
        });
        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog); //layout for dialog
                dialog.setTitle(item.getReason());
                dialog.setCancelable(true); //none-dismiss when touching outside Dialog

                TextView amount = (TextView) dialog.findViewById(R.id.amount);
                TextView type = (TextView) dialog.findViewById(R.id.type);
                TextView from = (TextView) dialog.findViewById(R.id.from);
                TextView reason = (TextView) dialog.findViewById(R.id.reason);
                TextView status = (TextView) dialog.findViewById(R.id.status);
                TextView trans = (TextView) dialog.findViewById(R.id.tran);

                amount.setText(item.getAmount());
                type.setText(item.getType());
                from.setText(item.getFrom());
                reason.setText(item.getReason());
                status.setText(item.getStatus());
                trans.setText(item.getId());

                dialog.show();
                Toast.makeText(context, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
//        viewHolder.swipeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dialog); //layout for dialog
//                dialog.setTitle(item.getReason());
//                dialog.setCancelable(true); //none-dismiss when touching outside Dialog
//
//                TextView amount = (TextView) dialog.findViewById(R.id.amount);
//                TextView type = (TextView) dialog.findViewById(R.id.type);
//                TextView from = (TextView) dialog.findViewById(R.id.from);
//                TextView reason = (TextView) dialog.findViewById(R.id.reason);
//                TextView status = (TextView) dialog.findViewById(R.id.status);
//                TextView trans = (TextView) dialog.findViewById(R.id.tran);
//
//                amount.setText(item.getAmount());
//                type.setText(item.getType());
//                from.setText(item.getFrom());
//                reason.setText(item.getReason());
//                status.setText(item.getStatus());
//                trans.setText(item.getId());
//
//                dialog.show();
//
////                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        if(item.getType().equals("request")&& item.getStatus().equals("pending")) {
            viewHolder.good.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemManger.removeShownLayouts(viewHolder.swipeLayout);
//                mDataset.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, mDataset.size());
//                mItemManger.closeAllItems();
                    Toast.makeText(view.getContext(), "Perform action for processing for" + item.getReason(), Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.bad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemManger.removeShownLayouts(viewHolder.swipeLayout);
//                mDataset.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, mDataset.size());
//                mItemManger.closeAllItems();
                    Toast.makeText(view.getContext(), "Cancel transaction request for " + item.getReason(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(item.getType().equals("send") && item.getStatus().equals("completed")) {
            viewHolder.good.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemManger.removeShownLayouts(viewHolder.swipeLayout);
//                mDataset.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, mDataset.size());
//                mItemManger.closeAllItems();
                    Toast.makeText(view.getContext(), "Perceived", Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.bad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemManger.removeShownLayouts(viewHolder.swipeLayout);
//                mDataset.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, mDataset.size());
//                mItemManger.closeAllItems();
                    Toast.makeText(view.getContext(), "Cancel perceived", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;
        TextView amount;
        TextView message;
        TextView status;
        ImageButton good, bad;
        CardView cv;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            amount = (TextView) itemView.findViewById(R.id.amount);
            message = (TextView) itemView.findViewById(R.id.msg);
            status = (TextView) itemView.findViewById(R.id.status);
            good = (ImageButton) itemView.findViewById(R.id.good);
            bad = (ImageButton) itemView.findViewById(R.id.bad);
            cv = (CardView) itemView.findViewById(R.id.cv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Log.d(getClass().getSimpleName(), "onItemSelected: " + textViewData.getText().toString());
//                    Toast.makeText(view.getContext(), "onItemSelected: " + textViewData.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
