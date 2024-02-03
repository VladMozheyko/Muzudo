package com.example.muzudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muzudo.model.Boiler;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class BoilerDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boiler_details);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos", 0);
        ImageView imageView = findViewById(R.id.boiler_details_image);
        imageView.setImageResource(Repository.boilers.get(pos).getImg());

        ArrayList<JsonReader.BoilerParameters> boilers =  JsonReader.getBoilerModelsFromJSON(this, "boilers.json");

        JsonReader.BoilerParameters boilerParams = boilers.get(pos);

        TextView exhaustTypeTextView = findViewById(R.id.txt_exhaust_type);
        TextView heatingPowerTextView = findViewById(R.id.txt_heating_power);
        TextView hotWaterPowerTextView = findViewById(R.id.txt_hot_water_power);
        TextView heatingPerformanceTextView = findViewById(R.id.txt_heating_performance);
        TextView hotWaterPerformanceTextView = findViewById(R.id.txt_hot_water_performance);
        TextView efficiencyAtFullPowerTextView = findViewById(R.id.txt_efficiency_at_full_power);
        TextView efficiencyAtMinPowerTextView = findViewById(R.id.txt_efficiency_at_min_power);
        TextView maxNaturalGasConsumptionTextView = findViewById(R.id.txt_max_natural_gas_consumption);
        TextView airPressureInExpansionTankTextView = findViewById(R.id.txt_air_pressure_in_expansion_tank);
        TextView expansionTankVolumeTextView = findViewById(R.id.txt_expansion_tank_volume);
        TextView pressureInHeatingCircuitTextView = findViewById(R.id.txt_pressure_in_heating_circuit);
        TextView temperatureControlRangeSupplyLineTextView = findViewById(R.id.txt_temperature_control_range_supply_line);
        TextView temperatureControlRangeRadiatorModeTextView = findViewById(R.id.txt_temperature_control_range_radiator_mode);
        TextView temperatureControlRangeFloorHeatingModeTextView = findViewById(R.id.txt_temperature_control_range_floor_heating_mode);
        TextView temperatureControlRangeIndirectHeatingBoilerTextView = findViewById(R.id.txt_temperature_control_range_indirect_heating_boiler);
        TextView hotWaterProduction25DegreesDeltaTTextView = findViewById(R.id.txt_hot_water_production_25_degrees_delta_t);
        TextView hotWaterProduction30DegreesDeltaTTextView = findViewById(R.id.txt_hot_water_production_30_degrees_delta_t);
        TextView hotWaterProduction35DegreesDeltaTTextView = findViewById(R.id.txt_hot_water_production_35_degrees_delta_t);
        TextView minStartingWaterFlowTextView = findViewById(R.id.txt_min_starting_water_flow);
        TextView minMaxPressureInHWCCircuitTextView = findViewById(R.id.txt_min_max_pressure_in_hwc_circuit);
        TextView boilerGasConnectionTextView = findViewById(R.id.txt_boiler_gas_connection);
        TextView heatingLinesConnectionTextView = findViewById(R.id.txt_heating_lines_connection);
        TextView coldAndHotWaterConnectionTextView = findViewById(R.id.txt_cold_and_hot_water_connection);
        TextView nominalVoltageFrequencyTextView = findViewById(R.id.txt_nominal_voltage_frequency);
        TextView powerConsumptionTextView = findViewById(R.id.txt_power_consumption);
        TextView electricalProtectionClassTextView = findViewById(R.id.txt_electrical_protection_class);
        TextView netWeightTextView = findViewById(R.id.txt_net_weight);
        TextView dimensionsTextView = findViewById(R.id.txt_dimensions);

        exhaustTypeTextView.setText(boilerParams.getExhaustType());
        heatingPowerTextView.setText(boilerParams.getHeatingPower().getMin()+ " - " + boilerParams.getHeatingPower().getMax());
        hotWaterPowerTextView.setText(boilerParams.getHotWaterPower().getMin() + " - " + boilerParams.getHotWaterPower().getMax() );
        heatingPerformanceTextView.setText(boilerParams.getHeatingPerformance().getMin() + " - " + boilerParams.getHeatingPerformance().getMax() );
        hotWaterPerformanceTextView.setText(boilerParams.getHotWaterPerformance());
        efficiencyAtFullPowerTextView.setText(boilerParams.getEfficiencyAtFullPower());
        efficiencyAtMinPowerTextView.setText(boilerParams.getEfficiencyAtMinPower());
        maxNaturalGasConsumptionTextView.setText(boilerParams.getMaxNaturalGasConsumption());
        airPressureInExpansionTankTextView.setText(boilerParams.getAirPressureInExpansionTank());
        expansionTankVolumeTextView.setText(boilerParams.getExpansionTankVolume());
        pressureInHeatingCircuitTextView.setText(boilerParams.getPressureInHeatingCircuit());
        temperatureControlRangeSupplyLineTextView.setText(boilerParams.getTemperatureControlRangeSupplyLine().getRange());
        temperatureControlRangeRadiatorModeTextView.setText(boilerParams.getTemperatureControlRangeRadiatorMode().getRange());
        temperatureControlRangeFloorHeatingModeTextView.setText(boilerParams.getTemperatureControlRangeFloorHeatingMode().getRange());
        temperatureControlRangeIndirectHeatingBoilerTextView.setText(boilerParams.getTemperatureControlRangeIndirectHeatingBoiler().getRange());
        hotWaterProduction25DegreesDeltaTTextView.setText(boilerParams.getHotWaterProduction25DegreesDeltaT());
        hotWaterProduction30DegreesDeltaTTextView.setText(boilerParams.getHotWaterProduction30DegreesDeltaT());
        hotWaterProduction35DegreesDeltaTTextView.setText(boilerParams.getHotWaterProduction35DegreesDeltaT());
        minStartingWaterFlowTextView.setText(boilerParams.getMinStartingWaterFlow());
        minMaxPressureInHWCCircuitTextView.setText(boilerParams.getMinMaxPressureInHWCCircuit());
        boilerGasConnectionTextView.setText(boilerParams.getBoilerGasConnection());
        heatingLinesConnectionTextView.setText(boilerParams.getHeatingLinesConnection());
        coldAndHotWaterConnectionTextView.setText(boilerParams.getColdAndHotWaterConnection());
        nominalVoltageFrequencyTextView.setText(boilerParams.getNominalVoltageFrequency());
        powerConsumptionTextView.setText(boilerParams.getPowerConsumption());
        electricalProtectionClassTextView.setText(boilerParams.getElectricalProtectionClass());
        netWeightTextView.setText(boilerParams.getNetWeight());
        dimensionsTextView.setText(boilerParams.getDimensions());



    }
}