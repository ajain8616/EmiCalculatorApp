package com.example.emicalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import java.util.List;

public class BankAdapter extends BaseAdapter {
    private Context context;
    private List<Bank> bankList;

    public BankAdapter(Context context, List<Bank> bankList) {
        this.context = context;
        this.bankList = bankList;
    }

    @Override
    public int getCount() {
        return bankList.size();
    }

    @Override
    public Object getItem(int position) {
        return bankList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.bank_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.bankNameTextView = convertView.findViewById(R.id.bank_name);
            viewHolder.interestRateTextView = convertView.findViewById(R.id.interest_rate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Bank bank = bankList.get(position);

        viewHolder.bankNameTextView.setText(bank.getName());
        viewHolder.interestRateTextView.setText(String.valueOf(bank.getInterestRate()));

        // Set click listener for interest_rate TextView
        viewHolder.interestRateTextView.setOnClickListener(v -> {
            // Auto-fill the interest rate in the EditText
            if (context instanceof MainActivity2) {
                EditText etInterestRate = ((MainActivity2) context).findViewById(R.id.etInterestRate);
                etInterestRate.setText(String.valueOf(bank.getInterestRate()));

                // Scroll to make sure the EditText is visible
                ListView listView = ((MainActivity2) context).findViewById(R.id.list_item);
                int positionToScroll = listView.getFirstVisiblePosition() + position;
                listView.smoothScrollToPosition(positionToScroll);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView bankNameTextView;
        TextView interestRateTextView;
    }
}
