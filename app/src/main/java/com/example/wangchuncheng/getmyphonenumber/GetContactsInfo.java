package com.example.wangchuncheng.getmyphonenumber;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangChunCheng on 2017/12/11.
 */

public class GetContactsInfo {
    Cursor mCursor;
    List<PhoneInfo> mContatsList = new ArrayList<PhoneInfo>();

    public GetContactsInfo(Context context){
            mCursor = context.getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
    }
    public List<PhoneInfo> getContacts(){
        String mContactName,mContactNum;
        while (mCursor.moveToNext()){

            mContactName = mCursor.getString(mCursor.getColumnIndex(Phone.DISPLAY_NAME));
            mContactNum = mCursor.getString(mCursor.getColumnIndex(Phone.NUMBER));
            PhoneInfo phoneInfo = new PhoneInfo(mContactName,mContactNum);
            mContatsList.add(phoneInfo);
            System.out.println(mContactName+mContactNum);
        }
        return mContatsList;
    }
}
