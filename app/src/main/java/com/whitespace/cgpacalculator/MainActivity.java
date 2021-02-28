package com.whitespace.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
    private ImageView Up_arrow, Info;
    private LinearLayout First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Nineth, Tenth, Eleventh, Twelveth;
    private TextView CG1, CG2, CG3, CG4, CG5, CG6, CG7, CG8, CG9, CG10, CG11, CG12;
    private TextView Total_CGPA, Total_Credit;

    Dialog popup;

    private String f1_cgpa, f2_cgpa, f3_cgpa, f4_cgpa, f5_cgpa, f6_cgpa, f7_cgpa, f8_cgpa, f9_cgpa, f10_cgpa, f11_cgpa, f12_cgpa;
    private String f1_credit, f2_credit, f3_credit, f4_credit, f5_credit, f6_credit, f7_credit, f8_credit, f9_credit, f10_credit, f11_credit, f12_credit;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String FIRST_CGPA = "first_cgpa";
    public static final String SECOND_CGPA = "second_cgpa";
    public static final String THIRD_CGPA = "third_cgpa";
    public static final String FOURTH_CGPA = "fourth_cgpa";
    public static final String FIFTH_CGPA = "fifth_cgpa";
    public static final String SIXTH_CGPA = "sixth_cgpa";
    public static final String SEVENTH_CGPA = "seventh_cgpa";
    public static final String EIGHTH_CGPA = "eighth_cgpa";
    public static final String NINETH_CGPA = "nineth_cgpa";
    public static final String TENTH_CGPA = "tenth_cgpa";
    public static final String ELEVENTH_CGPA = "eleventh_cgpa";
    public static final String TWELVETH_CGPA = "twelveth_cgpa";

    public static final String FIRST_CREDIT = "first_credit";
    public static final String SECOND_CREDIT = "second_credit";
    public static final String THIRD_CREDIT = "third_credit";
    public static final String FOURTH_CREDIT = "fourth_credit";
    public static final String FIFTH_CREDIT = "fifth_credit";
    public static final String SIXTH_CREDIT = "sisth_credit";
    public static final String SEVENTH_CREDIT = "seventh_credit";
    public static final String EIGHTH_CREDIT = "eighth_credit";
    public static final String NINETH_CREDIT = "nineth_credit";
    public static final String TENTH_CREDIT = "tenth_credit";
    public static final String ELEVENTH_CREDIT = "eveventh_credit";
    public static final String TWELVETH_CREDIT = "twelveth_credit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        Up_arrow = findViewById(R.id.up_arrow);
        Info = findViewById(R.id.info);

        First = findViewById(R.id.first);
        Second = findViewById(R.id.second);
        Third = findViewById(R.id.third);
        Fourth = findViewById(R.id.fourth);
        Fifth = findViewById(R.id.fifth);
        Sixth = findViewById(R.id.sixth);
        Seventh = findViewById(R.id.seventh);
        Eighth = findViewById(R.id.eighth);
        Nineth = findViewById(R.id.nineth);
        Tenth = findViewById(R.id.tenth);
        Eleventh = findViewById(R.id.eleventh);
        Twelveth = findViewById(R.id.twelveth);

        CG1 = findViewById(R.id.cg1);
        CG2 = findViewById(R.id.cg2);
        CG3 = findViewById(R.id.cg3);
        CG4 = findViewById(R.id.cg4);
        CG5 = findViewById(R.id.cg5);
        CG6 = findViewById(R.id.cg6);
        CG7 = findViewById(R.id.cg7);
        CG8 = findViewById(R.id.cg8);
        CG9 = findViewById(R.id.cg9);
        CG10 = findViewById(R.id.cg10);
        CG11 = findViewById(R.id.cg11);
        CG12 = findViewById(R.id.cg12);

        Total_CGPA = findViewById(R.id.total_cgpa);
        Total_Credit = findViewById(R.id.total_credit);


        popup = new Dialog(this);

        //Function calls

        loadData();

        First();
        Second();
        Third();
        Fourth();
        Fifth();
        Sixth();
        Seventh();
        Eighth();
        Nineth();
        Tenth();
        Eleventh();
        Twelveth();

        //...............

        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });


        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Up_arrow.setVisibility(View.GONE);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        loadData();
                        Up_arrow.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

    }

    private void First() {
        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("1st");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorRed), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(FIRST_CGPA).apply();
                            editor.remove(FIRST_CREDIT).apply();
                            CG1.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(FIRST_CGPA, cgpa.getText().toString());
                            editor.putString(FIRST_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f1_cgpa = sharedPreferences.getString(FIRST_CGPA, "");
                            f1_credit = sharedPreferences.getString(FIRST_CREDIT, "");
                            CG1.setText(f1_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f1_cgpa = sharedPreferences.getString(FIRST_CGPA, "");
                f1_credit = sharedPreferences.getString(FIRST_CREDIT, "");
                cgpa.setText(f1_cgpa);
                credit.setText(f1_credit);
            }
        });
    }

    private void Second() {
        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("2nd");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorBlue), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(SECOND_CGPA).apply();
                            editor.remove(SECOND_CREDIT).apply();
                            CG2.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(SECOND_CGPA, cgpa.getText().toString());
                            editor.putString(SECOND_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f2_cgpa = sharedPreferences.getString(SECOND_CGPA, "");
                            f2_credit = sharedPreferences.getString(SECOND_CREDIT, "");
                            CG2.setText(f2_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f2_cgpa = sharedPreferences.getString(SECOND_CGPA, "");
                f2_credit = sharedPreferences.getString(SECOND_CREDIT, "");
                cgpa.setText(f2_cgpa);
                credit.setText(f2_credit);
            }
        });
    }

    private void Third() {
        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("3rd");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorPink), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();


                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(THIRD_CGPA).apply();
                            editor.remove(THIRD_CREDIT).apply();
                            CG3.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(THIRD_CGPA, cgpa.getText().toString());
                            editor.putString(THIRD_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f3_cgpa = sharedPreferences.getString(THIRD_CGPA, "");
                            f3_credit = sharedPreferences.getString(THIRD_CREDIT, "");
                            CG3.setText(f3_cgpa);

                            popup.dismiss();
                        }

                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f3_cgpa = sharedPreferences.getString(THIRD_CGPA, "");
                f3_credit = sharedPreferences.getString(THIRD_CREDIT, "");
                cgpa.setText(f3_cgpa);
                credit.setText(f3_credit);
            }
        });
    }

    private void Fourth() {
        Fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("4th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorPurple), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(FOURTH_CGPA).apply();
                            editor.remove(FOURTH_CREDIT).apply();
                            CG4.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(FOURTH_CGPA, cgpa.getText().toString());
                            editor.putString(FOURTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f4_cgpa = sharedPreferences.getString(FOURTH_CGPA, "");
                            f4_credit = sharedPreferences.getString(FOURTH_CREDIT, "");
                            CG4.setText(f4_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f4_cgpa = sharedPreferences.getString(FOURTH_CGPA, "");
                f4_credit = sharedPreferences.getString(FOURTH_CREDIT, "");
                cgpa.setText(f4_cgpa);
                credit.setText(f4_credit);
            }
        });
    }

    private void Fifth() {
        Fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("5th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorOrange), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(FIFTH_CGPA).apply();
                            editor.remove(FIFTH_CREDIT).apply();
                            CG5.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(FIFTH_CGPA, cgpa.getText().toString());
                            editor.putString(FIFTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f5_cgpa = sharedPreferences.getString(FIFTH_CGPA, "");
                            f5_credit = sharedPreferences.getString(FIFTH_CREDIT, "");
                            CG5.setText(f5_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f5_cgpa = sharedPreferences.getString(FIFTH_CGPA, "");
                f5_credit = sharedPreferences.getString(FIFTH_CREDIT, "");
                cgpa.setText(f5_cgpa);
                credit.setText(f5_credit);
            }
        });
    }

    private void Sixth() {
        Sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("6th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorViolate), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(SIXTH_CGPA).apply();
                            editor.remove(SIXTH_CREDIT).apply();
                            CG6.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(SIXTH_CGPA, cgpa.getText().toString());
                            editor.putString(SIXTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f6_cgpa = sharedPreferences.getString(SIXTH_CGPA, "");
                            f6_credit = sharedPreferences.getString(SIXTH_CREDIT, "");
                            CG6.setText(f6_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f6_cgpa = sharedPreferences.getString(SIXTH_CGPA, "");
                f6_credit = sharedPreferences.getString(SIXTH_CREDIT, "");
                cgpa.setText(f6_cgpa);
                credit.setText(f6_credit);
            }
        });
    }

    private void Seventh() {
        Seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("7th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorCyan), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(SEVENTH_CGPA).apply();
                            editor.remove(SEVENTH_CREDIT).apply();
                            CG7.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(SEVENTH_CGPA, cgpa.getText().toString());
                            editor.putString(SEVENTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f7_cgpa = sharedPreferences.getString(SEVENTH_CGPA, "");
                            f7_credit = sharedPreferences.getString(SEVENTH_CREDIT, "");
                            CG7.setText(f7_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f7_cgpa = sharedPreferences.getString(SEVENTH_CGPA, "");
                f7_credit = sharedPreferences.getString(SEVENTH_CREDIT, "");
                cgpa.setText(f7_cgpa);
                credit.setText(f7_credit);
            }
        });
    }

    private void Eighth() {
        Eighth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("8th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorYellow), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(EIGHTH_CGPA).apply();
                            editor.remove(EIGHTH_CREDIT).apply();
                            CG8.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(EIGHTH_CGPA, cgpa.getText().toString());
                            editor.putString(EIGHTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f8_cgpa = sharedPreferences.getString(EIGHTH_CGPA, "");
                            f8_credit = sharedPreferences.getString(EIGHTH_CREDIT, "");
                            CG8.setText(f8_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f8_cgpa = sharedPreferences.getString(EIGHTH_CGPA, "");
                f8_credit = sharedPreferences.getString(EIGHTH_CREDIT, "");
                cgpa.setText(f8_cgpa);
                credit.setText(f8_credit);
            }
        });
    }

    private void Nineth() {
        Nineth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("9th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorLightGreen), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(NINETH_CGPA).apply();
                            editor.remove(NINETH_CREDIT).apply();
                            CG9.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(NINETH_CGPA, cgpa.getText().toString());
                            editor.putString(NINETH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f9_cgpa = sharedPreferences.getString(NINETH_CGPA, "");
                            f9_credit = sharedPreferences.getString(NINETH_CREDIT, "");
                            CG9.setText(f9_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f9_cgpa = sharedPreferences.getString(NINETH_CGPA, "");
                f9_credit = sharedPreferences.getString(NINETH_CREDIT, "");
                cgpa.setText(f9_cgpa);
                credit.setText(f9_credit);
            }
        });
    }

    private void Tenth() {
        Tenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("10th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorIndigo), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(TENTH_CGPA).apply();
                            editor.remove(TENTH_CREDIT).apply();
                            CG10.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(TENTH_CGPA, cgpa.getText().toString());
                            editor.putString(TENTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f10_cgpa = sharedPreferences.getString(TENTH_CGPA, "");
                            f10_credit = sharedPreferences.getString(TENTH_CREDIT, "");
                            CG10.setText(f10_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f10_cgpa = sharedPreferences.getString(TENTH_CGPA, "");
                f10_credit = sharedPreferences.getString(TENTH_CREDIT, "");
                cgpa.setText(f10_cgpa);
                credit.setText(f10_credit);
            }
        });
    }

    private void Eleventh() {
        Eleventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("11th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorGreen), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(ELEVENTH_CGPA).apply();
                            editor.remove(ELEVENTH_CREDIT).apply();
                            CG11.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(ELEVENTH_CGPA, cgpa.getText().toString());
                            editor.putString(ELEVENTH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f11_cgpa = sharedPreferences.getString(ELEVENTH_CGPA, "");
                            f11_credit = sharedPreferences.getString(ELEVENTH_CREDIT, "");
                            CG11.setText(f11_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f11_cgpa = sharedPreferences.getString(ELEVENTH_CGPA, "");
                f11_credit = sharedPreferences.getString(ELEVENTH_CREDIT, "");
                cgpa.setText(f11_cgpa);
                credit.setText(f11_credit);
            }
        });
    }

    private void Twelveth() {
        Twelveth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setContentView(R.layout.popup);
                popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView title = popup.findViewById(R.id.title);
                title.setText("12th");
                ImageView save = popup.findViewById(R.id.save);
                ImageView close = popup.findViewById(R.id.close_popup);
                final EditText cgpa = popup.findViewById(R.id.cgpa);
                final EditText credit = popup.findViewById(R.id.credit);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                save.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorAmber), android.graphics.PorterDuff.Mode.MULTIPLY);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        if (cgpa.getText().toString().equals("") && credit.getText().toString().equals("")) {
                            editor.remove(TWELVETH_CGPA).apply();
                            editor.remove(TWELVETH_CREDIT).apply();
                            CG12.setText("0.00");
                            popup.dismiss();
                        } else if (cgpa.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "CGPA can not be empty", Toast.LENGTH_SHORT).show();
                        } else if (credit.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Credit can not be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            editor.putString(TWELVETH_CGPA, cgpa.getText().toString());
                            editor.putString(TWELVETH_CREDIT, credit.getText().toString());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                            sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            f12_cgpa = sharedPreferences.getString(TWELVETH_CGPA, "");
                            f12_credit = sharedPreferences.getString(TWELVETH_CREDIT, "");
                            CG12.setText(f12_cgpa);

                            popup.dismiss();
                        }
                    }
                });
                popup.show();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                f12_cgpa = sharedPreferences.getString(TWELVETH_CGPA, "");
                f12_credit = sharedPreferences.getString(TWELVETH_CREDIT, "");
                cgpa.setText(f12_cgpa);
                credit.setText(f12_credit);
            }
        });
    }


    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        f1_cgpa = sharedPreferences.getString(FIRST_CGPA, "0.00");
        f2_cgpa = sharedPreferences.getString(SECOND_CGPA, "0.00");
        f3_cgpa = sharedPreferences.getString(THIRD_CGPA, "0.00");
        f4_cgpa = sharedPreferences.getString(FOURTH_CGPA, "0.00");
        f5_cgpa = sharedPreferences.getString(FIFTH_CGPA, "0.00");
        f6_cgpa = sharedPreferences.getString(SIXTH_CGPA, "0.00");
        f7_cgpa = sharedPreferences.getString(SEVENTH_CGPA, "0.00");
        f8_cgpa = sharedPreferences.getString(EIGHTH_CGPA, "0.00");
        f9_cgpa = sharedPreferences.getString(NINETH_CGPA, "0.00");
        f10_cgpa = sharedPreferences.getString(TENTH_CGPA, "0.00");
        f11_cgpa = sharedPreferences.getString(ELEVENTH_CGPA, "0.00");
        f12_cgpa = sharedPreferences.getString(TWELVETH_CGPA, "0.00");

        f1_credit = sharedPreferences.getString(FIRST_CREDIT, "0");
        f2_credit = sharedPreferences.getString(SECOND_CREDIT, "0");
        f3_credit = sharedPreferences.getString(THIRD_CREDIT, "0");
        f4_credit = sharedPreferences.getString(FOURTH_CREDIT, "0");
        f5_credit = sharedPreferences.getString(FIFTH_CREDIT, "0");
        f6_credit = sharedPreferences.getString(SIXTH_CREDIT, "0");
        f7_credit = sharedPreferences.getString(SEVENTH_CREDIT, "0");
        f8_credit = sharedPreferences.getString(EIGHTH_CREDIT, "0");
        f9_credit = sharedPreferences.getString(NINETH_CREDIT, "0");
        f10_credit = sharedPreferences.getString(TENTH_CREDIT, "0");
        f11_credit = sharedPreferences.getString(ELEVENTH_CREDIT, "0");
        f12_credit = sharedPreferences.getString(TWELVETH_CREDIT, "0");

        CG1.setText(f1_cgpa);
        CG2.setText(f2_cgpa);
        CG3.setText(f3_cgpa);
        CG4.setText(f4_cgpa);
        CG5.setText(f5_cgpa);
        CG6.setText(f6_cgpa);
        CG7.setText(f7_cgpa);
        CG8.setText(f8_cgpa);
        CG9.setText(f9_cgpa);
        CG10.setText(f10_cgpa);
        CG11.setText(f11_cgpa);
        CG12.setText(f12_cgpa);

        Float fcg1, fcg2, fcg3, fcg4, fcg5, fcg6, fcg7, fcg8, fcg9, fcg10, fcg11, fcg12;
        Float fc1, fc2, fc3, fc4, fc5, fc6, fc7, fc8, fc9, fc10, fc11, fc12;

        fcg1 = Float.valueOf(f1_cgpa);
        fcg2 = Float.valueOf(f2_cgpa);
        fcg3 = Float.valueOf(f3_cgpa);
        fcg4 = Float.valueOf(f4_cgpa);
        fcg5 = Float.valueOf(f5_cgpa);
        fcg6 = Float.valueOf(f6_cgpa);
        fcg7 = Float.valueOf(f7_cgpa);
        fcg8 = Float.valueOf(f8_cgpa);
        fcg9 = Float.valueOf(f9_cgpa);
        fcg10 = Float.valueOf(f10_cgpa);
        fcg11 = Float.valueOf(f11_cgpa);
        fcg12 = Float.valueOf(f12_cgpa);

        fc1 = Float.valueOf(f1_credit);
        fc2 = Float.valueOf(f2_credit);
        fc3 = Float.valueOf(f3_credit);
        fc4 = Float.valueOf(f4_credit);
        fc5 = Float.valueOf(f5_credit);
        fc6 = Float.valueOf(f6_credit);
        fc7 = Float.valueOf(f7_credit);
        fc8 = Float.valueOf(f8_credit);
        fc9 = Float.valueOf(f9_credit);
        fc10 = Float.valueOf(f10_credit);
        fc11 = Float.valueOf(f11_credit);
        fc12 = Float.valueOf(f12_credit);

        Float favg_cg1 = (fcg1 * fc1);
        Float favg_cg2 = (fcg2 * fc2);
        Float favg_cg3 = (fcg3 * fc3);
        Float favg_cg4 = (fcg4 * fc4);
        Float favg_cg5 = (fcg5 * fc5);
        Float favg_cg6 = (fcg6 * fc6);
        Float favg_cg7 = (fcg7 * fc7);
        Float favg_cg8 = (fcg8 * fc8);
        Float favg_cg9 = (fcg9 * fc9);
        Float favg_cg10 = (fcg10 * fc10);
        Float favg_cg11 = (fcg11 * fc11);
        Float favg_cg12 = (fcg12 * fc12);

        Float favg_cg = favg_cg1 + favg_cg2 + favg_cg3 + favg_cg4 + favg_cg5 + favg_cg6 + favg_cg7 + favg_cg8 + favg_cg9 + favg_cg10 + favg_cg11 + favg_cg12;
        Float favg_c = fc1 + fc2 + fc3 + fc4 + fc5 + fc6 + fc7 + fc8 + fc9 + fc10 + fc11 + fc12;

        Float T_CGPA = favg_cg / favg_c;
        String CGPA = String.format("%.2f", T_CGPA);
        if (CGPA.equals("NaN")) {
            Total_CGPA.setText("0.00");
        } else {
            Total_CGPA.setText(CGPA);
        }
    }
}