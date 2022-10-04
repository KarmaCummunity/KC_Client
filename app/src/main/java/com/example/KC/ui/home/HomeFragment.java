package com.example.KC.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.KC.R;

import java.util.Random;


public class HomeFragment extends Fragment implements View.OnClickListener {


    private String[][] sentences = new String[100][2];
    private Random rand = new Random();

    private HomeViewModel homeViewModel;
    private LinearLayout sentences_View;
    private TextView sentence, sentence_author;
    private Integer i = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        fill();
        sentences_View = root.findViewById(R.id.sentences_View);
        sentence = root.findViewById(R.id.textView);
        sentence_author = root.findViewById(R.id.textView1);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //sentence.setText(s);
            }
        });
        sentences_View.setOnClickListener(this);
        return root;
    }
    
    public void onClick(View arg0) {
        try {

            Integer i2 = rand.nextInt(10);
            i++;
            Handler hendler = new Handler();
            hendler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (i == 2) {
                        sentence.setText("\"" + sentences[i2][0] + "\"");
                        sentence_author.setText(sentences[i2][1]);
                        i=0;
                    }
                i=0;
                }
            }, 500);
        } catch (Exception e) {
            e.printStackTrace();
            sentence.setText("i= ");
            sentence_author.setText(e.getMessage());

        }
    }

    public void fill() {
        sentences[0][0] = "אתה תמיד גדול כגודל העניין שאתה משרת ואתה נהייה קטן אם אתה משרת רק את עצמך";
        sentences[0][1] = "ש. פרס";
        sentences[1][0] = "אנשים מסוימים ישנאו אותך על היותך שונה, אבל בפנים הם מייחלים שיהיה להם אומץ לעשות אותו הדבר";
        sentences[1][1] = "ק. הארט";
        sentences[2][0] = "ככל שאנחנו משתפרים ככה הבעיות מסתבכות";
        sentences[2][1] = "נ. סרוסי";
        sentences[3][0] = "מי שמפחד להסתכן, מסתכן בחיים של בינוניות";
        sentences[3][1] = "ש. כהן";
        sentences[4][0] = "אומץ הוא לא תמיד שאגה, לפעמים אומץ הוא קול חלוש בסוף היום שאומר - מחר אנסה פעם נוספת";
        sentences[4][1] = "מרי אן ראדמאכר";
        sentences[5][0] = "הדבר היחיד שהוא יותר גרוע מלהתחיל ולהיכשל, הוא לא להתחיל בכלל";
        sentences[5][1] = "סת' גודין";
        sentences[6][0] = "אם תמיד תנסו להיות נורמלים, לעולם לא תדעו כמה מדהימים אתם יכולים להיות";
        sentences[6][1] = "מ. אנג'לו";
        sentences[7][0] = "כשאתה יודע מה המטרה שלך, העולם הופך לספרייה שמספקת לך הידע הדרוש";
        sentences[7][1] = "ק. בראינט";
        sentences[8][0] = "את מה שהזחל מכנה הסוף, שאר העולם מכנה פרפר";
        sentences[8][1] = "אנונימי";
        sentences[9][0] = "אדם פסימי רואה את הקושי בכל הזדמנות, אדם אופטימי רואה הזדמנות בכל קושי";
        sentences[9][1] = "ו. צ'רצ'יל";
        sentences[10][0] = "הרמה שבה אנשים מכבדים אותך היא פונקציה של כמה אתה מכבד את עצמך";
        sentences[10][1] = "ש. כהן";
    }
}