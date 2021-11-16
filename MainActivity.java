package com.example.homework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;  // 다시 공부해서 뭔지 이해하기  ??????????????????????
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        public void aaa(View target){
            setContentView(R);

        }



        final EditText etext;   //여기에 etext 라는ㄴ 이름의 edit text를 만들었는데   @@@@@@@@@@@
        Button btnr;
        Button btno;
        Button btne;
        TextView tv;
        TextView end;

        int result;           // 왜 이렇게 전역변수로 쓰려고 하면 밑에 오류생기는지 모르겠음 btnr.setOnClickListener 안에 int result 를 넣으면 지역변수라서 클릭이 끝나면 숫자 저장이 안되자너
        int tr = 0;           // 위에 ??????????????????????????????????????????????
        int fl = 0;
        int all = tr + fl;
        double per = (double) tr/all;                           //
        String sper = String.format("%.2f", per);               //소수 2째 자리만 나오게 하기위한 로직

        etext = (EditText) findViewById(R.id.et1);  // 그 etext 는 et1을 의미한다   @@@@@@@@@@@@
        btnr = (Button) findViewById(R.id.buttonr);
        btno = (Button) findViewById(R.id.buttonO);
        btne = (Button) findViewById(R.id.buttone) ;
        tv = (TextView) findViewById(R.id.textView);
        end = (TextView) findViewById(R.id.textView3);

        btnr.setOnClickListener(new View.OnClickListener() {    //btnr 눌렀을때   이벤트 리스너   : 랜덤한 수식생성     하지만 부팅시 자동실행 어찌???????????????????
            @Override
            public void onClick(View view) {
                Random ran = new Random();                  //랜덤 쓸것이다.
                int num1 = ran.nextInt(99)+1;         //num1 이란 랜던숫자 범위설정
                int num2 = ran.nextInt(99)+1;         //num2 라는 랜덤숫자 범위설정
                boolean op = ran.nextBoolean();             //랜덤 True false
                String bl;

                if (op)
                {
                    bl = "+";
                    result = num1+num2;
                }
                else
                {
                    bl = "-";
                    result = num1-num2;
                }

                tv.setText(String.valueOf(num1)+bl+String.valueOf(num2));

            }
        });

        btno.setOnClickListener(new View.OnClickListener() {    //버튼누를시 정답과 비교 토글 생성
            @Override
            public void onClick(View view) {

                String oks = etext.getText().toString();    //int 로 못가져와서 스트링으로 가져온다음에
                int oki = Integer.parseInt(oks);            //다시 int 로 바꾸기

                if (oki == result){
                    tr++;
                    Toast.makeText(getApplicationContext(),"정답입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    fl++;
                    Toast.makeText(getApplicationContext(),"틀렸습니다. 정답은"+result+"입니다.",Toast.LENGTH_SHORT).show(); // 토스트 안에 변수 내용띄우기 이거 맞음?????????
                }

            }
        });

        btne.setOnClickListener(new View.OnClickListener() { // 버튼을 누를시 종료와함께 정답률 텍스트 새로 보여짐
            @Override
            public void onClick(View view) {

                end.setText(String.valueOf(all)+"번 중에"+String.valueOf(tr)+"번 정답 , 정답률: "+String.valueOf(sper));

            }
        });

    }

}

/////////////////왜 백그라운드 틴트 백그라운드 둘다 바꿔도 버튼 색 안바뀜??????????????????????????????????????????????????
