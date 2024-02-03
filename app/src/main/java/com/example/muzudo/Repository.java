package com.example.muzudo;

import com.example.muzudo.model.Boiler;
import com.example.muzudo.model.Geyser;
import com.example.muzudo.model.User;

import java.util.ArrayList;

public class Repository {
    public static ArrayList<Integer> onBoardingImages = new ArrayList<>();
    public static ArrayList<Integer> onBoardingStates = new ArrayList<>();
    public static ArrayList<Integer> onBoardingStatePositions = new ArrayList<>();
    public static ArrayList<Integer> error_codes = new ArrayList<>();
    public static ArrayList<Integer> instructionsList = new ArrayList<>();
    public static ArrayList<Integer> repairList = new ArrayList<>();

    public static ArrayList<Boiler> boilers = new ArrayList<>();

    public static ArrayList<Geyser> geysers = new ArrayList<>();
    public static User user;
    static {
        onBoardingImages.add(R.drawable.onboarding_img1);
        onBoardingImages.add(R.drawable.onboarding_img2);
        onBoardingImages.add(R.drawable.onboarding_img3);
        onBoardingImages.add(R.drawable.onboarding_img4);
        onBoardingImages.add(R.drawable.onboarding_img5);

        onBoardingStates.add(R.drawable.onboarding_selected);
        onBoardingStates.add(R.drawable.onboarding_free);

        error_codes.add(R.drawable.error_codes_1);
        error_codes.add(R.drawable.errors_code_2);
        error_codes.add(R.drawable.errors_code_3);

        instructionsList.add(R.drawable.instructions_1);
        instructionsList.add(R.drawable.instructions_2);
        instructionsList.add(R.drawable.instructions_3);
        instructionsList.add(R.drawable.instructions_4);
        instructionsList.add(R.drawable.instructions_5);
        instructionsList.add(R.drawable.instructions_6);
        instructionsList.add(R.drawable.instructions_7);
        instructionsList.add(R.drawable.instructions_8);
        instructionsList.add(R.drawable.instructions_9);
        instructionsList.add(R.drawable.instructions_10);
        instructionsList.add(R.drawable.instructions_11);
        instructionsList.add(R.drawable.instructions_12);
        instructionsList.add(R.drawable.instructions_13);
        instructionsList.add(R.drawable.instructions_14);
        instructionsList.add(R.drawable.instructions_15);
        instructionsList.add(R.drawable.instructions_16);
        instructionsList.add(R.drawable.instructions_17);
        instructionsList.add(R.drawable.instructions_18);
        instructionsList.add(R.drawable.instructions_19);
        instructionsList.add(R.drawable.instructions_20);
        instructionsList.add(R.drawable.instructions_21);
        instructionsList.add(R.drawable.instructions_22);
        instructionsList.add(R.drawable.instructions_23);
        instructionsList.add(R.drawable.instructions_24);

        onBoardingImages.add(R.drawable.onboarding_img1);
        onBoardingImages.add(R.drawable.onboarding_img2);
        onBoardingImages.add(R.drawable.onboarding_img3);
        onBoardingImages.add(R.drawable.onboarding_img4);
        onBoardingImages.add(R.drawable.onboarding_img5);

        onBoardingStatePositions.add(R.id.onboardingStateImg1);
        onBoardingStatePositions.add(R.id.onboardingStateImg2);
        onBoardingStatePositions.add(R.id.onboardingStateImg3);
        onBoardingStatePositions.add(R.id.onboardingStateImg4);
        onBoardingStatePositions.add(R.id.onboardingStateImg5);

        repairList.add(R.drawable.repair1);
        repairList.add(R.drawable.repair2);
        repairList.add(R.drawable.repair3);
        repairList.add(R.drawable.repair4);
        repairList.add(R.drawable.repair5);
        repairList.add(R.drawable.repair6);
        repairList.add(R.drawable.repair7);
        repairList.add(R.drawable.repair8);
        repairList.add(R.drawable.repair9);
        repairList.add(R.drawable.repair10);
        repairList.add(R.drawable.repair11);
        repairList.add(R.drawable.repair12);
        repairList.add(R.drawable.repair13);
        repairList.add(R.drawable.repair14);
        repairList.add(R.drawable.repair15);
        repairList.add(R.drawable.repair16);
        repairList.add(R.drawable.repair17);
        repairList.add(R.drawable.repair18);
        repairList.add(R.drawable.repair19);
        repairList.add(R.drawable.repair20);
        repairList.add(R.drawable.repair21);
        repairList.add(R.drawable.repair22);
        repairList.add(R.drawable.repair23);
        repairList.add(R.drawable.repair24);
        repairList.add(R.drawable.repair25);
        repairList.add(R.drawable.repair26);
        repairList.add(R.drawable.repair27);
        repairList.add(R.drawable.repair28);
        repairList.add(R.drawable.repair29);
        repairList.add(R.drawable.repair30);
        repairList.add(R.drawable.repair31);
        repairList.add(R.drawable.repair32);
        repairList.add(R.drawable.repair33);
        repairList.add(R.drawable.repair34);
        repairList.add(R.drawable.repair35);
        repairList.add(R.drawable.repair36);
        repairList.add(R.drawable.repair37);
        repairList.add(R.drawable.repair38);
        repairList.add(R.drawable.repair39);
        repairList.add(R.drawable.repair40);
        repairList.add(R.drawable.repair41);
        repairList.add(R.drawable.repair42);
        repairList.add(R.drawable.repair43);
        repairList.add(R.drawable.repair44);
        repairList.add(R.drawable.repair45);
        repairList.add(R.drawable.repair46);
        repairList.add(R.drawable.repair47);
        repairList.add(R.drawable.repair48);
        repairList.add(R.drawable.repair49);
        repairList.add(R.drawable.repair50);
        repairList.add(R.drawable.repair51);
        repairList.add(R.drawable.repair52);
        repairList.add(R.drawable.repair53);
        repairList.add(R.drawable.repair54);
        repairList.add(R.drawable.repair55);
        repairList.add(R.drawable.repair56);
        repairList.add(R.drawable.repair57);
        repairList.add(R.drawable.repair58);
        repairList.add(R.drawable.repair59);
        repairList.add(R.drawable.repair60);
        repairList.add(R.drawable.repair61);
        repairList.add(R.drawable.repair62);
        repairList.add(R.drawable.repair63);
        repairList.add(R.drawable.repair64);
        repairList.add(R.drawable.repair65);
        repairList.add(R.drawable.repair66);
        repairList.add(R.drawable.repair67);
        repairList.add(R.drawable.repair68);
        repairList.add(R.drawable.repair69);
        repairList.add(R.drawable.repair70);
        repairList.add(R.drawable.repair71);
        repairList.add(R.drawable.repair72);
        repairList.add(R.drawable.repair73);
        repairList.add(R.drawable.repair74);
        repairList.add(R.drawable.repair75);
        repairList.add(R.drawable.repair76);
        repairList.add(R.drawable.repair77);

        boilers.add(new Boiler(R.drawable.m20t, "M20T"));
        boilers.add(new Boiler(R.drawable.m24t, "M24TH"));
        boilers.add(new Boiler(R.drawable.m28th, "M28TH"));
        boilers.add(new Boiler(R.drawable.m30th, "M30TH"));
        boilers.add(new Boiler(R.drawable.m32th, "M32TH"));
        boilers.add(new Boiler(R.drawable.m36th, "M36TH"));
        boilers.add(new Boiler(R.drawable.mt40h, "MT40H"));
        boilers.add(new Boiler(R.drawable.m11t, "M11T"));
        boilers.add(new Boiler(R.drawable.m13t, "M13T"));
        boilers.add(new Boiler(R.drawable.m15t, "M15T"));
        boilers.add(new Boiler(R.drawable.m17t, "M17T"));
        boilers.add(new Boiler(R.drawable.m20t, "M20T"));
        boilers.add(new Boiler(R.drawable.m24t, "M24T"));
        boilers.add(new Boiler(R.drawable.m24t_pro, "M24T pro"));
        boilers.add(new Boiler(R.drawable.m28t, "M28T"));
        boilers.add(new Boiler(R.drawable.m30t, "M30T"));
        boilers.add(new Boiler(R.drawable.m32t, "M32T"));
        boilers.add(new Boiler(R.drawable.m36t, "M36T"));
        boilers.add(new Boiler(R.drawable.m40t, "M40T"));
        boilers.add(new Boiler(R.drawable.m13th, "M11TH"));
        boilers.add(new Boiler(R.drawable.m13th, "M13TH"));
        boilers.add(new Boiler(R.drawable.m15th, "M15TH"));
        boilers.add(new Boiler(R.drawable.m17th, "M17TH"));
        //   boilers.add(new Boiler(R.drawable.m36tk, "M36TK"));
       // boilers.add(new Boiler(R.drawable.m20, "M20"));
       // boilers.add(new Boiler(R.drawable.m24, "M24"));
      //  boilers.add(new Boiler(R.drawable.m44tl, "M44TL"));
        boilers.add(new Boiler(R.drawable.m11tl, "M11TL"));
        boilers.add(new Boiler(R.drawable.m13tl, "M13TL"));
        boilers.add(new Boiler(R.drawable.m15tl, "M15TL"));
        boilers.add(new Boiler(R.drawable.m17tl, "M17TL"));
//        boilers.add(new Boiler(R.drawable.m36t, "M36T"));
  //      boilers.add(new Boiler(R.drawable.m36th, "M36TH"));
//        boilers.add(new Boiler(R.drawable.m36tk, "M36TK"));
//        boilers.add(new Boiler(R.drawable.m40t, "M40T"));
//        boilers.add(new Boiler(R.drawable.m44tl, "M44TL"));

        geysers.add(new Geyser(R.drawable.vpg_2_10_mm_, "ВПГ 2-10 ММ"));
        geysers.add(new Geyser(R.drawable.vpg_2_11_em, "ВПГ 2-11 ЭМ"));
        geysers.add(new Geyser(R.drawable.vpg_2_11_mm_, "ВПГ 2-11 ММ"));
        geysers.add(new Geyser(R.drawable.vpg_2_14_em, "ВПГ 2-14 ЭМ"));
        geysers.add(new Geyser(R.drawable.vpg_2_14_mm, "ВПГ 2-14 ММ"));
        geysers.add(new Geyser(R.drawable.vpg_3_10_, "ВПГ 3-10"));
        geysers.add(new Geyser(R.drawable.vpg_3_11, "ВПГ 3-11"));
        geysers.add(new Geyser(R.drawable.vpg_3_14, "ВПГ 3-14"));
        geysers.add(new Geyser(R.drawable.vpg_4_10_t, "ВПГ 4-10"));
        geysers.add(new Geyser(R.drawable.vpg_4_11_t, "ВПГ 4-11"));
        geysers.add(new Geyser(R.drawable.vpg_4_12_t_, "ВПГ 4-12"));
        geysers.add(new Geyser(R.drawable.vpg_4_14_t_, "ВПГ 4-14"));


    }

}
