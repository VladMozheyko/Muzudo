package com.example.muzudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GeyserDetailsActivity extends AppCompatActivity {

    TableLayout tableLayout;

    private float mScale = 1f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geyzer_details);

        Intent intent = getIntent();

        int count = intent.getIntExtra("pos", 0);

        ImageView imageView = findViewById(R.id.geyzer_details_image);
        TextView typeTextView = findViewById(R.id.type);
        TextView flameModulationTextView = findViewById(R.id.flameModulation);
        TextView nominalThermalPowerTextView = findViewById(R.id.nominalThermalPower);
        TextView heatProductivityTextView = findViewById(R.id.heatProductivity);
        TextView efficiencyTextView = findViewById(R.id.efficiency);
        TextView naturalGasTextView = findViewById(R.id.naturalGas);
        TextView liquefiedGasTextView = findViewById(R.id.liquefiedGas);
        TextView naturalGasConsumptionTextView = findViewById(R.id.naturalGasConsumption);
        TextView liquefiedGasConsumptionTextView = findViewById(R.id.liquefiedGasConsumption);
        TextView waterPressureForNormalOperationTextView = findViewById(R.id.waterPressureForNormalOperation);
        TextView minWaterFlowForIgnitionTextView = findViewById(R.id.minWaterFlowForIgnition);
        TextView waterFlowOnHeatingTextView = findViewById(R.id.waterFlowOnHeating);
        TextView ignitionTextView = findViewById(R.id.ignition);
        TextView powerSupplyTextView = findViewById(R.id.powerSupply);
        TextView voltageAndFrequencyTextView = findViewById(R.id.voltageAndFrequency);
        TextView coldWaterInletTextView = findViewById(R.id.coldWaterInlet);
        TextView hotWaterOutletTextView = findViewById(R.id.hotWaterOutlet);
        TextView gasInletTextView = findViewById(R.id.gasInlet);
        TextView grossWeightTextView = findViewById(R.id.grossWeight);
        TextView dimensionsTextView = findViewById(R.id.dimensions);
        TextView fluePipeSizeTextView = findViewById(R.id.fluePipeSize);
        TextView internalDiameterOfFlueNozzleTextView = findViewById(R.id.internalDiameterOfFlueNozzle);

        // Разбор JSON-объекта
       // try {
        List<JsonReader.Geyzer> geyzers = JsonReader.getModelsFromJSON(this, "geyzers.json");
        JsonReader.Geyzer geyzer = geyzers.get(count);


            typeTextView.setText(geyzer.getType());
            flameModulationTextView.setText(geyzer.getFlameModulation());
            nominalThermalPowerTextView.setText(geyzer.getNominalThermalPower());
            heatProductivityTextView.setText(geyzer.getHeatProductivity());
            efficiencyTextView.setText(geyzer.getEfficiency());
            naturalGasConsumptionTextView.setText(geyzer.getNaturalGasConsumption());
            liquefiedGasConsumptionTextView.setText(geyzer.getLiquefiedGasConsumption());
            waterPressureForNormalOperationTextView.setText(geyzer.getWaterPressureForNormalOperation());
            minWaterFlowForIgnitionTextView.setText(geyzer.getMinWaterFlowForIgnition());
            waterFlowOnHeatingTextView.setText(geyzer.getWaterFlowOnHeating());
            ignitionTextView.setText(geyzer.getIgnition());
            powerSupplyTextView.setText(geyzer.getPowerSupply());
            voltageAndFrequencyTextView.setText(geyzer.getVoltageAndFrequency());
            coldWaterInletTextView.setText(geyzer.getColdWaterInlet());
            hotWaterOutletTextView.setText(geyzer.getHotWaterOutlet());
            gasInletTextView.setText(geyzer.getGasInlet());
            grossWeightTextView.setText(geyzer.getGrossWeight());
            dimensionsTextView.setText(geyzer.getDimensions());
            fluePipeSizeTextView.setText(geyzer.getFluePipeSize());
            internalDiameterOfFlueNozzleTextView.setText(geyzer.getInternalDiameterOfFlueNozzle());

            naturalGasTextView.setText(geyzer.getNominalGasPressure().getNaturalGas());
           liquefiedGasTextView.setText(geyzer.getNominalGasPressure().getLiquefiedGas());
           imageView.setImageResource(Repository.geysers.get(count).getImg());

//        gestureDetector = new GestureDetector(this, new GeyserDetailsActivity.GestureListener());
//        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.
//                SimpleOnScaleGestureListener() {
//            @Override
//            public boolean onScale(ScaleGestureDetector detector) {
//
//                float scale = 1 - detector.getScaleFactor();
//                float prevScale = mScale;
//                mScale += scale;
//
//                if (mScale > 10f)
//                    mScale = 10f;
//
//                ScaleAnimation scaleAnimation = new ScaleAnimation(1f / prevScale,
//                        1f / mScale, 1f / prevScale, 1f / mScale,
//                        detector.getFocusX(), detector.getFocusY());
//                scaleAnimation.setDuration(0);
//                scaleAnimation.setFillAfter(true);
//                return true;
//            }
//        });

    }


}