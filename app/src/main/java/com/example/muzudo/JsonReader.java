package com.example.muzudo;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.muzudo.model.Boiler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public  static List<Geyzer> models;

    public static class Geyzer {
        private String name;
        private String type;
        private String flameModulation;
        private String nominalThermalPower;
        private String heatProductivity;
        private String efficiency;
        private GasPressure nominalGasPressure;
        private String naturalGasConsumption;
        private String liquefiedGasConsumption;
        private String waterPressureForNormalOperation;
        private String minWaterFlowForIgnition;
        private String waterFlowOnHeating;
        private String ignition;
        private String powerSupply;
        private String voltageAndFrequency;
        private String coldWaterInlet;
        private String hotWaterOutlet;
        private String gasInlet;
        private String grossWeight;
        private String dimensions;
        private String fluePipeSize;
        private String internalDiameterOfFlueNozzle;


        // Конструктор
        public Geyzer(String name, String type, String flameModulation, String nominalThermalPower,
                      String heatProductivity, String efficiency, GasPressure nominalGasPressure,
                      String naturalGasConsumption, String liquefiedGasConsumption,
                      String waterPressureForNormalOperation, String minWaterFlowForIgnition,
                      String waterFlowOnHeating, String ignition, String powerSupply,
                      String voltageAndFrequency, String coldWaterInlet, String hotWaterOutlet,
                      String gasInlet, String grossWeight, String dimensions, String fluePipeSize,
                      String internalDiameterOfFlueNozzle) {
            this.name = name;
            this.type = type;
            this.flameModulation = flameModulation;
            this.nominalThermalPower = nominalThermalPower;
            this.heatProductivity = heatProductivity;
            this.efficiency = efficiency;
            this.nominalGasPressure = nominalGasPressure;
            this.naturalGasConsumption = naturalGasConsumption;
            this.liquefiedGasConsumption = liquefiedGasConsumption;
            this.waterPressureForNormalOperation = waterPressureForNormalOperation;
            this.minWaterFlowForIgnition = minWaterFlowForIgnition;
            this.waterFlowOnHeating = waterFlowOnHeating;
            this.ignition = ignition;
            this.powerSupply = powerSupply;
            this.voltageAndFrequency = voltageAndFrequency;
            this.coldWaterInlet = coldWaterInlet;
            this.hotWaterOutlet = hotWaterOutlet;
            this.gasInlet = gasInlet;
            this.grossWeight = grossWeight;
            this.dimensions = dimensions;
            this.fluePipeSize = fluePipeSize;
            this.internalDiameterOfFlueNozzle = internalDiameterOfFlueNozzle;
        }

        // Геттеры для остальных параметров

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getFlameModulation() {
            return flameModulation;
        }

        public String getNominalThermalPower() {
            return nominalThermalPower;
        }

        public String getHeatProductivity() {
            return heatProductivity;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public GasPressure getNominalGasPressure() {
            return nominalGasPressure;
        }

        public String getNaturalGasConsumption() {
            return naturalGasConsumption;
        }

        public String getLiquefiedGasConsumption() {
            return liquefiedGasConsumption;
        }

        public String getWaterPressureForNormalOperation() {
            return waterPressureForNormalOperation;
        }

        public String getMinWaterFlowForIgnition() {
            return minWaterFlowForIgnition;
        }

        public String getWaterFlowOnHeating() {
            return waterFlowOnHeating;
        }

        public String getIgnition() {
            return ignition;
        }

        public String getPowerSupply() {
            return powerSupply;
        }

        public String getVoltageAndFrequency() {
            return voltageAndFrequency;
        }

        public String getColdWaterInlet() {
            return coldWaterInlet;
        }

        public String getHotWaterOutlet() {
            return hotWaterOutlet;
        }

        public String getGasInlet() {
            return gasInlet;
        }

        public String getGrossWeight() {
            return grossWeight;
        }

        public String getDimensions() {
            return dimensions;
        }

        public String getFluePipeSize() {
            return fluePipeSize;
        }

        public String getInternalDiameterOfFlueNozzle() {
            return internalDiameterOfFlueNozzle;
        }

        // ... остальные геттеры


        @Override
        public String toString() {
            return "Geyzer{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", flameModulation='" + flameModulation + '\'' +
                    ", nominalThermalPower=" + nominalThermalPower +
                    ", heatProductivity=" + heatProductivity +
                    ", efficiency=" + efficiency +
                    ", nominalGasPressure=" + nominalGasPressure +
                    ", naturalGasConsumption=" + naturalGasConsumption +
                    ", liquefiedGasConsumption='" + liquefiedGasConsumption + '\'' +
                    ", waterPressureForNormalOperation='" + waterPressureForNormalOperation + '\'' +
                    ", minWaterFlowForIgnition=" + minWaterFlowForIgnition +
                    ", waterFlowOnHeating=" + waterFlowOnHeating +
                    ", ignition='" + ignition + '\'' +
                    ", powerSupply='" + powerSupply + '\'' +
                    ", voltageAndFrequency='" + voltageAndFrequency + '\'' +
                    ", coldWaterInlet='" + coldWaterInlet + '\'' +
                    ", hotWaterOutlet='" + hotWaterOutlet + '\'' +
                    ", gasInlet='" + gasInlet + '\'' +
                    ", grossWeight=" + grossWeight +
                    ", dimensions='" + dimensions + '\'' +
                    ", fluePipeSize='" + fluePipeSize + '\'' +
                    ", internalDiameterOfFlueNozzle=" + internalDiameterOfFlueNozzle +
                    '}' + "\n";
        }
    }

    public static class GasPressure {
        private String naturalGas;
        private String liquefiedGas;

        // Конструктор
        public GasPressure(String naturalGas, String liquefiedGas) {
            this.naturalGas = naturalGas;
            this.liquefiedGas = liquefiedGas;
        }

        // Геттеры

        public String getNaturalGas() {
            return naturalGas;
        }

        public String getLiquefiedGas() {
            return liquefiedGas;
        }


    }


    public static class BoilerParameters {

        private String exhaustType;
        private TemperatureRange heatingPower;
        private TemperatureRange hotWaterPower;
        private TemperatureRange heatingPerformance;
        private String hotWaterPerformance;
        private String efficiencyAtFullPower;
        private String efficiencyAtMinPower;
        private String maxNaturalGasConsumption;
        private String airPressureInExpansionTank;
        private String expansionTankVolume;
        private String pressureInHeatingCircuit;
        private TemperatureRange temperatureControlRangeSupplyLine;
        private TemperatureRange temperatureControlRangeRadiatorMode;
        private TemperatureRange temperatureControlRangeFloorHeatingMode;
        private TemperatureRange temperatureControlRangeIndirectHeatingBoiler;
        private String hotWaterProduction25DegreesDeltaT;
        private String hotWaterProduction30DegreesDeltaT;
        private String hotWaterProduction35DegreesDeltaT;
        private String minStartingWaterFlow;
        private String minMaxPressureInHWCCircuit;
        private String boilerGasConnection;
        private String heatingLinesConnection;
        private String coldAndHotWaterConnection;
        private String nominalVoltageFrequency;
        private String powerConsumption;
        private String electricalProtectionClass;
        private String netWeight;
        private String dimensions;

        // Constructor
        public BoilerParameters(
                String exhaustType,
                TemperatureRange heatingPower,
                TemperatureRange hotWaterPower,
                TemperatureRange heatingPerformance,
                String hotWaterPerformance,
                String efficiencyAtFullPower,
                String efficiencyAtMinPower,
                String maxNaturalGasConsumption,
                String airPressureInExpansionTank,
                String expansionTankVolume,
                String pressureInHeatingCircuit,
                TemperatureRange temperatureControlRangeSupplyLine,
                TemperatureRange temperatureControlRangeRadiatorMode,
                TemperatureRange temperatureControlRangeFloorHeatingMode,
                TemperatureRange temperatureControlRangeIndirectHeatingBoiler,
                String hotWaterProduction25DegreesDeltaT,
                String hotWaterProduction30DegreesDeltaT,
                String hotWaterProduction35DegreesDeltaT,
                String minStartingWaterFlow,
                String minMaxPressureInHWCCircuit,
                String boilerGasConnection,
                String heatingLinesConnection,
                String coldAndHotWaterConnection,
                String nominalVoltageFrequency,
                String powerConsumption,
                String electricalProtectionClass,
                String netWeight,
                String dimensions) {

            this.exhaustType = exhaustType;
            this.heatingPower = heatingPower;
            this.hotWaterPower = hotWaterPower;
            this.heatingPerformance = heatingPerformance;
            this.hotWaterPerformance = hotWaterPerformance;
            this.efficiencyAtFullPower = efficiencyAtFullPower;
            this.efficiencyAtMinPower = efficiencyAtMinPower;
            this.maxNaturalGasConsumption = maxNaturalGasConsumption;
            this.airPressureInExpansionTank = airPressureInExpansionTank;
            this.expansionTankVolume = expansionTankVolume;
            this.pressureInHeatingCircuit = pressureInHeatingCircuit;
            this.temperatureControlRangeSupplyLine = temperatureControlRangeSupplyLine;
            this.temperatureControlRangeRadiatorMode = temperatureControlRangeRadiatorMode;
            this.temperatureControlRangeFloorHeatingMode = temperatureControlRangeFloorHeatingMode;
            this.temperatureControlRangeIndirectHeatingBoiler = temperatureControlRangeIndirectHeatingBoiler;
            this.hotWaterProduction25DegreesDeltaT = hotWaterProduction25DegreesDeltaT;
            this.hotWaterProduction30DegreesDeltaT = hotWaterProduction30DegreesDeltaT;
            this.hotWaterProduction35DegreesDeltaT = hotWaterProduction35DegreesDeltaT;
            this.minStartingWaterFlow = minStartingWaterFlow;
            this.minMaxPressureInHWCCircuit = minMaxPressureInHWCCircuit;
            this.boilerGasConnection = boilerGasConnection;
            this.heatingLinesConnection = heatingLinesConnection;
            this.coldAndHotWaterConnection = coldAndHotWaterConnection;
            this.nominalVoltageFrequency = nominalVoltageFrequency;
            this.powerConsumption = powerConsumption;
            this.electricalProtectionClass = electricalProtectionClass;
            this.netWeight = netWeight;
            this.dimensions = dimensions;
        }

        public String getExhaustType() {
            return exhaustType;
        }

        public TemperatureRange getHeatingPower() {
            return heatingPower;
        }

        public TemperatureRange getHotWaterPower() {
            return hotWaterPower;
        }

        public TemperatureRange getHeatingPerformance() {
            return heatingPerformance;
        }

        public String getHotWaterPerformance() {
            return hotWaterPerformance;
        }

        public String getEfficiencyAtFullPower() {
            return efficiencyAtFullPower;
        }

        public String getEfficiencyAtMinPower() {
            return efficiencyAtMinPower;
        }

        public String getMaxNaturalGasConsumption() {
            return maxNaturalGasConsumption;
        }

        public String getAirPressureInExpansionTank() {
            return airPressureInExpansionTank;
        }

        public String getExpansionTankVolume() {
            return expansionTankVolume;
        }

        public String getPressureInHeatingCircuit() {
            return pressureInHeatingCircuit;
        }

        public TemperatureRange getTemperatureControlRangeSupplyLine() {
            return temperatureControlRangeSupplyLine;
        }

        public TemperatureRange getTemperatureControlRangeRadiatorMode() {
            return temperatureControlRangeRadiatorMode;
        }

        public TemperatureRange getTemperatureControlRangeFloorHeatingMode() {
            return temperatureControlRangeFloorHeatingMode;
        }

        public TemperatureRange getTemperatureControlRangeIndirectHeatingBoiler() {
            return temperatureControlRangeIndirectHeatingBoiler;
        }

        public String getHotWaterProduction25DegreesDeltaT() {
            return hotWaterProduction25DegreesDeltaT;
        }

        public String getHotWaterProduction30DegreesDeltaT() {
            return hotWaterProduction30DegreesDeltaT;
        }

        public String getHotWaterProduction35DegreesDeltaT() {
            return hotWaterProduction35DegreesDeltaT;
        }

        public String getMinStartingWaterFlow() {
            return minStartingWaterFlow;
        }

        public String getMinMaxPressureInHWCCircuit() {
            return minMaxPressureInHWCCircuit;
        }

        public String getBoilerGasConnection() {
            return boilerGasConnection;
        }

        public String getHeatingLinesConnection() {
            return heatingLinesConnection;
        }

        public String getColdAndHotWaterConnection() {
            return coldAndHotWaterConnection;
        }

        public String getNominalVoltageFrequency() {
            return nominalVoltageFrequency;
        }

        public String getPowerConsumption() {
            return powerConsumption;
        }

        public String getElectricalProtectionClass() {
            return electricalProtectionClass;
        }

        public String getNetWeight() {
            return netWeight;
        }

        public String getDimensions() {
            return dimensions;
        }

        @Override
        public String toString() {
            return "BoilerParameters{" +
                    "exhaustType='" + exhaustType + '\'' +
                    ", heatingPower=" + heatingPower +
                    ", hotWaterPower=" + hotWaterPower +
                    ", heatingPerformance=" + heatingPerformance +
                    ", hotWaterPerformance='" + hotWaterPerformance + '\'' +
                    ", efficiencyAtFullPower='" + efficiencyAtFullPower + '\'' +
                    ", efficiencyAtMinPower='" + efficiencyAtMinPower + '\'' +
                    ", maxNaturalGasConsumption='" + maxNaturalGasConsumption + '\'' +
                    ", airPressureInExpansionTank='" + airPressureInExpansionTank + '\'' +
                    ", expansionTankVolume='" + expansionTankVolume + '\'' +
                    ", pressureInHeatingCircuit='" + pressureInHeatingCircuit + '\'' +
                    ", temperatureControlRangeSupplyLine=" + temperatureControlRangeSupplyLine +
                    ", temperatureControlRangeRadiatorMode=" + temperatureControlRangeRadiatorMode +
                    ", temperatureControlRangeFloorHeatingMode=" + temperatureControlRangeFloorHeatingMode +
                    ", temperatureControlRangeIndirectHeatingBoiler=" + temperatureControlRangeIndirectHeatingBoiler +
                    ", hotWaterProduction25DegreesDeltaT='" + hotWaterProduction25DegreesDeltaT + '\'' +
                    ", hotWaterProduction30DegreesDeltaT='" + hotWaterProduction30DegreesDeltaT + '\'' +
                    ", hotWaterProduction35DegreesDeltaT='" + hotWaterProduction35DegreesDeltaT + '\'' +
                    ", minStartingWaterFlow='" + minStartingWaterFlow + '\'' +
                    ", minMaxPressureInHWCCircuit='" + minMaxPressureInHWCCircuit + '\'' +
                    ", boilerGasConnection='" + boilerGasConnection + '\'' +
                    ", heatingLinesConnection='" + heatingLinesConnection + '\'' +
                    ", coldAndHotWaterConnection='" + coldAndHotWaterConnection + '\'' +
                    ", nominalVoltageFrequency='" + nominalVoltageFrequency + '\'' +
                    ", powerConsumption='" + powerConsumption + '\'' +
                    ", electricalProtectionClass='" + electricalProtectionClass + '\'' +
                    ", netWeight='" + netWeight + '\'' +
                    ", dimensions='" + dimensions + '\'' +
                    '}' + "\n";
        }
    }

    public static class TemperatureRange {
        private String min;
        private String max;

        private String range;

        // Constructor
        public TemperatureRange(String min, String max) {
            this.min = min;
            this.max = max;
        }

        public TemperatureRange(String range) {
            this.range = range;
        }

        public String getMin() {
            return min;
        }

        public String getMax() {
            return max;
        }

        public String getRange() {
            return range;
        }

        // Getter and Setter methods...
    }



    public static ArrayList<BoilerParameters> getBoilerModelsFromJSON(Context context, String fileName)  {
        ArrayList<BoilerParameters> models = new ArrayList<>();
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(fileName);
            String jsonString = readJsonFile(inputStream);

            JSONArray jsonArray = new JSONArray(jsonString);
            Log.d("ARRAY_SIZE: ", " "+ jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject modelObject = jsonArray.getJSONObject(i);

                // Извлекаем необходимые данные из объекта JSON
                String exhaustType = modelObject.getString("Тип дымоудаления");
                JSONObject heatingPowerObj = modelObject.getJSONObject("Тепловая мощность отопления");
                TemperatureRange heatingPower = new TemperatureRange(
                        heatingPowerObj.getString("Мин."),
                        heatingPowerObj.getString("Макс.")
                );
                JSONObject hotWaterPowerObj = modelObject.getJSONObject("Тепловая мощность ГВС");
                TemperatureRange hotWaterPower = new TemperatureRange(
                        hotWaterPowerObj.getString("Мин."),
                        hotWaterPowerObj.getString("Макс.")
                );
                JSONObject heatingPerformanceObj = modelObject.getJSONObject("Теплопроизводительность отопления");
                TemperatureRange heatingPerformance = new TemperatureRange(
                        heatingPerformanceObj.getString("Мин."),
                        heatingPerformanceObj.getString("Макс.")
                );
                String hotWaterPerformance = modelObject.getString("Теплопроизводительность ГВС");
                String efficiencyAtFullPower = modelObject.getString("КПД при 100% тепловой мощности");
                String efficiencyAtMinPower = modelObject.getString("КПД при минимальной мощности");
                String maxNaturalGasConsumption = modelObject.getString("Максимальный расход природного газа");
                String airPressureInExpansionTank = modelObject.getString("Давление в воздушной полости расширительного бака");
                String expansionTankVolume = modelObject.getString("Объем расширительного бака");
                String pressureInHeatingCircuit = modelObject.getString("Давление в отопительном контуре");
                TemperatureRange temperatureControlRangeSupplyLine = new TemperatureRange(
                        modelObject.getString("Диапазон регулировки температуры в подающей линии"));
                TemperatureRange temperatureControlRangeRadiatorMode = new TemperatureRange(
                        modelObject.getString("Диапазон регулировки температуры в режиме радиатора"));
                TemperatureRange temperatureControlRangeFloorHeatingMode = new TemperatureRange(
                        modelObject.getString("Диапазон регулировки температуры в режиме подогрева пола"));
                TemperatureRange temperatureControlRangeIndirectHeatingBoiler = new TemperatureRange(
                        modelObject.getString("Диапазон регулировки температуры бойлера косвенного нагрева"));
                String hotWaterProduction25DegreesDeltaT = modelObject.getString("Производительность по нагреву горячей воды （при △T=25℃）");
                String hotWaterProduction30DegreesDeltaT = modelObject.getString("Производительность по нагреву горячей воды（при △T=30℃）");
                String hotWaterProduction35DegreesDeltaT = modelObject.getString("Производительность по нагреву горячей воды（при △T=35℃）");
                String minStartingWaterFlow = modelObject.getString("Минимальный пусковой расход воды");
                String minMaxPressureInHWCCircuit = modelObject.getString("Мин./макс. давление в контуре ГВС");
                String boilerGasConnection = modelObject.getString("Присоединительный газовый патрубок котла");
                String heatingLinesConnection = modelObject.getString("Патрубки подключения подающей и обратной линий отопления котла");
                String coldAndHotWaterConnection = modelObject.getString("Подключение холодной и горячей воды");
                String nominalVoltageFrequency = modelObject.getString("Номинальное напряжение/частота");
                String powerConsumption = modelObject.getString("Потребляемая эл. мощность");
                String electricalProtectionClass = modelObject.getString("Класс электрозащиты");
                String netWeight = modelObject.getString("Вес, нетто");
                String dimensions = modelObject.getString("Габаритные размеры");

                // Создаем объект BoilerParameters и добавляем его в ArrayList
                BoilerParameters boilerParameters = new BoilerParameters(
                        exhaustType,
                        heatingPower,
                        hotWaterPower,
                        heatingPerformance,
                        hotWaterPerformance,
                        efficiencyAtFullPower,
                        efficiencyAtMinPower,
                        maxNaturalGasConsumption,
                        airPressureInExpansionTank,
                        expansionTankVolume,
                        pressureInHeatingCircuit,
                        temperatureControlRangeSupplyLine,
                        temperatureControlRangeRadiatorMode,
                        temperatureControlRangeFloorHeatingMode,
                        temperatureControlRangeIndirectHeatingBoiler,
                        hotWaterProduction25DegreesDeltaT,
                        hotWaterProduction30DegreesDeltaT,
                        hotWaterProduction35DegreesDeltaT,
                        minStartingWaterFlow,
                        minMaxPressureInHWCCircuit,
                        boilerGasConnection,
                        heatingLinesConnection,
                        coldAndHotWaterConnection,
                        nominalVoltageFrequency,
                        powerConsumption,
                        electricalProtectionClass,
                        netWeight,
                        dimensions
                );

                Log.d("ADD BOILER: ", " "+ boilerParameters.toString());
                models.add(boilerParameters);
            }


        } catch (IOException | JSONException e) {
        e.printStackTrace();
    }


//                GasPressure nominalGasPressure = new GasPressure(
//                        modelObject.getJSONObject("Номинальное давление газа").getString("Природный газ"),
//                        modelObject.getJSONObject("Номинальное давление газа").getString("Сжиженный газ")
//                );
//
//                Geyzer model = new Geyzer(
//                        modelObject.getString("Название"),
//                        modelObject.getString("Тип"),
//                        modelObject.getString("Режим пламени"),
//                        modelObject.getString("Номинальная тепловая мощность"),
//                        modelObject.getString("Теплопроизводительность"),
//                        modelObject.getString("Эффективность"),
//                        nominalGasPressure,
//                        modelObject.getString("Расход природного газа"),
//                        modelObject.getString("Расход сжиженного газа"),
//                        modelObject.getString("Давление воды для нормальной работы"),
//                        modelObject.getString("Минимальный расход воды для зажигания"),
//                        modelObject.getString("Расход воды при нагреве"),
//                        modelObject.getString("Зажигание"),
//                        modelObject.getString("Питание"),
//                        modelObject.getString("Напряжение и частота"),
//                        modelObject.getString("Подача холодной воды"),
//                        modelObject.getString("Отвод горячей воды"),
//                        modelObject.getString("Подача газа"),
//                        modelObject.getString("Вес"),
//                        modelObject.getString("Габаритные размеры"),
//                        modelObject.getString("Размер дымохода"),
//                        modelObject.getString("Внутренний диаметр дымоотвода")
//                );
//
//                models.add(model);
//                Log.d("JSON: ", model.toString());
//            }
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
       // }
        Log.d("MODELS_SIZE: ", " " +models.size());
        return models;
    }

    private static String readJsonFile(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
    public static List<Geyzer> getModelsFromJSON(Context context, String fileName) {
       models = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(json);
            JSONObject specifications = jsonObject.getJSONObject("specifications");
            JSONArray modelsArray = specifications.getJSONArray("models");

            Log.d("JSON size:"," " + modelsArray.length());
            for (int i = 0; i < modelsArray.length(); i++) {
                JSONObject modelObject = modelsArray.getJSONObject(i);

                GasPressure nominalGasPressure = new GasPressure(
                        modelObject.getJSONObject("nominalGasPressure").getString("naturalGas"),
                        modelObject.getJSONObject("nominalGasPressure").getString("liquefiedGas")
                );

                Geyzer model = new Geyzer(
                        modelObject.getString("name"),
                        modelObject.getString("type"),
                        modelObject.getString("flameModulation"),
                        modelObject.getString("nominalThermalPower"),
                        modelObject.getString("heatProductivity"),
                        modelObject.getString("efficiency"),
                        nominalGasPressure,
                        modelObject.getString("naturalGasConsumption"),
                        modelObject.getString("liquefiedGasConsumption"),
                        modelObject.getString("waterPressureForNormalOperation"),
                        modelObject.getString("minWaterFlowForIgnition"),
                        modelObject.getString("waterFlowOnHeating"),
                        modelObject.getString("ignition"),
                        modelObject.getString("powerSupply"),
                        modelObject.getString("voltageAndFrequency"),
                        modelObject.getString("coldWaterInlet"),
                        modelObject.getString("hotWaterOutlet"),
                        modelObject.getString("gasInlet"),
                        modelObject.getString("grossWeight"),
                        modelObject.getString("dimensions"),
                        modelObject.getString("fluePipeSize"),
                        modelObject.getString("internalDiameterOfFlueNozzle")
                );

                models.add(model);
                Log.d("f JSON:", model.toString());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return models;
    }
}