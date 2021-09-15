package com.project.agriculturalapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.project.agriculturalapp.R;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class  ChatbotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        Kommunicate.init(this, "29ba0df0f86066036fdb23157eff8766c");
        Kommunicate.init(this, "81763a0a2d51419e589ffebaa0e7ae37");
        new KmConversationBuilder(this)
                .launchConversation(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {
                        Log.d("Conversation", "Success : " + message);
                    }

                    @Override
                    public void onFailure(Object error) {
                        Log.d("Conversation", "Failure : " + error);
                    }
                });
    }}
//}<script type="text/javascript">
//        (function(d, m){
//        var kommunicateSettings =
//        {"appId":"6a6d62369490ec3e95907db6bb206c24","popupWidget":true,"automaticChatOpenOnNavigation":true};
//        var s = document.createElement("script"); s.type = "text/javascript"; s.async = true;
//        s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
//        var h = document.getElementsByTagName("head")[0]; h.appendChild(s);
//        window.kommunicate = m; m._globals = kommunicateSettings;
//        })(document, window.kommunicate || {});
///* NOTE : Use web server to view HTML files as real-time update will not work if you directly open the HTML file in the browser. */
//</script>