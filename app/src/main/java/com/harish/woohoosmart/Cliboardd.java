package com.harish.woohoosmart;

import static android.content.Context.CLIPBOARD_SERVICE;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Cliboardd  {


    Context context;
    public Cliboardd(Context context) {
    this.context=context;

    }
    public void clip(String text){
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager)context.getSystemService(CLIPBOARD_SERVICE);
        ClipData myClip;
        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);
        Toast.makeText(context.getApplicationContext(), "Text copied to Clipboard", Toast.LENGTH_SHORT).show();

    }
   public void IntentCLip(String Text){
    Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT,Text );
    sendIntent.setType("text/plain");
    sendIntent.setPackage("com.whatsapp");
    context.startActivity(sendIntent);
}



}
