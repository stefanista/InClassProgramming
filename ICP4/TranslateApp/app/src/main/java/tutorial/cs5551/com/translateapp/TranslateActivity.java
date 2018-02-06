package tutorial.cs5551.com.translateapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TranslateActivity extends AppCompatActivity {

    String API_URL = "https://api.fullcontact.com/v2/person.json?";
    String API_KEY = "b29103a702edd6a";
    String sourceText;
    TextView outputTextView;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        outputTextView = (TextView) findViewById(R.id.txt_Result);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);

        outputTextView = (TextView) findViewById(R.id.txt_Result);
    }

    public String getCode(String lang){

        String code = "en";
        switch (lang){
            case "Azerbaijan":
                code = "az";
                break;
            case "Albanian":
                code = "sq";
                break;
            case "Amharic":
                code = "am";
                break;
            case "English":
                code = "en";
                break;
            case "Arabic":
                code = "ar";
                break;
            case "Armenian":
                code = "hy";
                break;
            case "Afrikaans":
                code = "af";
                break;
            case "Basque":
                code = "eu";
                break;
            case "Bashkir":
                code = "ba";
                break;
            case "Belarusian":
                code = "be";
                break;
            case "Bengali":
                code = "bn";
                break;
            case "Burmese":
                code = "my";
                break;
            case "Bulgarian":
                code = "bg";
                break;
            case "Bosnian":
                code = "bs";
                break;
            case "Welsh":
                code = "cy";
                break;
            case "Hungarian":
                code = "hu";
                break;
            case "Vietnamese":
                code = "vi";
                break;
            case "Haitian (Creole)":
                code = "ht";
                break;
            case "Galician":
                code = "gl";
                break;
            case "Dutch":
                code = "nl";
                break;
            case "Hill Mari":
                code = "mrj";
                break;
            case"Greek":
                code = "el";
                break;
            case "Georgian":
                code = "ka";
                break;
            case "Gujarati":
                code = "gu";
                break;
            case "Danish":
                code = "da";
                break;
            case "Hebrew":
                code = "he";
                break;
            case "Yiddish":
                code = "yi";
                break;
            case "Indonesian":
                code = "id";
                break;
            case "Irish":
                code = "ga";
                break;
            case "Italian":
                code = "it";
                break;
            case "Icelandic":
                code = "is";
                break;
            case "Spanish":
                code = "es";
                break;
            case "Kazakh":
                code = "kk";
                break;
            case "Kannada":
                code = "kn";
                break;
            case "Catalan":
                code = "ca";
                break;
            case "Kyrgyz":
                code = "ky";
                break;
            case "Chinese":
                code = "zh";
                break;
            case "Korean":
                code = "ko";
                break;
            case "Xhosa":
                code = "xh";
                break;
            case "Khmer":
                code = "km";
                break;
            case "Laotian":
                code = "lo";
                break;
            case "Latin":
                code = "la";
                break;
            case "Latvian":
                code = "lv";
                break;
            case "Lithuanian":
                code = "lt";
                break;
            case "Luxembourgish":
                code = "lb";
                break;
            case "Malagasy":
                code = "mg";
                break;
            case "Malay":
                code = "ms";
                break;
            case "Malayalam":
                code = "ml";
                break;
            case "Maltese":
                code = "mt";
                break;
            case "Macedonian":
                code = "mk";
                break;
            case "Maori":
                code = "mi";
                break;
            case "Marathi":
                code = "mr";
                break;
            case "Mari":
                code = "mhr";
                break;
            case "Mongolian":
                code = "mn";
                break;
            case "German":
                code = "de";
                break;
            case "Nepali":
                code = "ne";
                break;
            case "Norwegian":
                code = "no";
                break;
            case "Punjabi":
                code = "pa";
                break;
            case "Papiamento":
                code = "pap";
                break;
            case "Persian":
                code = "fa";
                break;
            case "Polish":
                code = "pl";
                break;
            case "Portuguese":
                code = "pt";
                break;
            case "Romanian":
                code = "ro";
                break;
            case "Russian":
                code = "ru";
                break;
            case "Cebuano":
                code = "ceb";
                break;
            case "Serbian":
                code = "sr";
                break;
            case "Sinhala":
                code = "si";
                break;
            case "Slovakian":
                code = "sk";
                break;
            case "Slovenian":
                code = "sl";
                break;
            case "Swahili":
                code = "sw";
                break;
            case "Sudanese":
                code = "su";
                break;
            case "Tajik":
                code = "tg";
                break;
            case "Thai":
                code = "th";
                break;
            case "Tagalog":
                code = "tl";
                break;
            case "Tamil":
                code = "ta";
                break;
            case "Tatar":
                code = "tt";
                break;
            case "Telugu":
                code = "te";
                break;
            case "Turkish":
                code = "tr";
                break;
            case "Udmurt":
                code = "udm";
                break;
            case "Uzbek":
                code = "uz";
                break;
            case "Ukrainian":
                code = "uk";
                break;
            case "Urdu":
                code = "ur";
                break;
            case "Finnish":
                code = "fi";
                break;
            case "French":
                code = "fr";
                break;
            case "Hindi":
                code = "hi";
                break;
            case "Croatian":
                code = "hr";
                break;
            case "Czech":
                code = "cs";
                break;
            case "Swedish":
                code = "sv";
                break;
            case "Scottish":
                code = "gd";
                break;
            case "Estonian":
                code = "et";
                break;
            case "Esperanto":
                code = "eo";
                break;
            case "Javanese":
                code = "jv";
                break;
            case "Japanese":
                code = "ja";
                break;

            default:
                code = "en";
                break;
        }


        return code;
    }


    public void logout(View v) {
        Intent redirect = new Intent(TranslateActivity.this, LoginActivity.class);
        startActivity(redirect);
    }
    public void translateText(View v) {
        TextView sourceTextView = (TextView) findViewById(R.id.txt_Email);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        String source = spinner.getSelectedItem().toString();
        String target = spinner2.getSelectedItem().toString();

        String src = getCode(source);
        String trgt = getCode(target);

        sourceText = sourceTextView.getText().toString();
        String getURL = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
                "key=trnsl.1.1.20151023T145251Z.bf1ca7097253ff7e." +
                "c0b0a88bea31ba51f72504cc0cc42cf891ed90d2&text=" + sourceText +"&" +
                "lang="+src+"-"+trgt+"&[format=plain]&[options=1]&[callback=set]";//The API service URL
        final String response1 = "";
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(getURL)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final JSONObject jsonResult;
                    final String result = response.body().string();
                    try {
                        jsonResult = new JSONObject(result);
                        JSONArray convertedTextArray = jsonResult.getJSONArray("text");
                        final String convertedText = convertedTextArray.get(0).toString();
                        Log.d("okHttp", jsonResult.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                outputTextView.setText(convertedText);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });


        } catch (Exception ex) {
            outputTextView.setText(ex.getMessage());

        }

    }
}
