package org.sionnach.bot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    private Long idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;
    private String strSource;
    private String strImageSource;
    private String strCreativeCommonsConfirmed;
    private String dateModified;

    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();

        if (getStrIngredient1() == null || getStrIngredient1().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient1());
        }

        if (getStrIngredient2() == null || getStrIngredient2().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient2());
        }

        if (getStrIngredient3() == null || getStrIngredient3().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient3());
        }

        if (getStrIngredient4() == null || getStrIngredient4().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient4());
        }

        if (getStrIngredient5() == null || getStrIngredient5().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient5());
        }

        if (getStrIngredient6() == null || getStrIngredient6().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient6());
        }

        if (getStrIngredient7() == null || getStrIngredient7().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient7());
        }

        if (getStrIngredient8() == null || getStrIngredient8().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient8());
        }

        if (getStrIngredient9() == null || getStrIngredient9().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient9());
        }

        if (getStrIngredient10() == null || getStrIngredient10().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient10());
        }

        if (getStrIngredient11() == null || getStrIngredient11().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient11());
        }

        if (getStrIngredient12() == null || getStrIngredient12().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient12());
        }

        if (getStrIngredient13() == null || getStrIngredient13().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient13());
        }

        if (getStrIngredient14() == null || getStrIngredient14().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient14());
        }

        if (getStrIngredient15() == null || getStrIngredient15().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient15());
        }

        if (getStrIngredient16() == null || getStrIngredient16().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient16());
        }

        if (getStrIngredient17() == null || getStrIngredient17().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient17());
        }

        if (getStrIngredient18() == null || getStrIngredient18().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient18());
        }

        if (getStrIngredient19() == null || getStrIngredient19().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient19());
        }

        if (getStrIngredient20() == null || getStrIngredient20().isEmpty()) {
            return ingredients;
        } else {
            ingredients.add(getStrIngredient20());
        }

        return ingredients;
    }

    public List<String> getMeasures() {
        List<String> measures = new ArrayList<>();

        if (getStrMeasure1() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure1());
        }

        if (getStrMeasure2() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure2());
        }

        if (getStrMeasure3() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure3());
        }

        if (getStrMeasure4() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure4());
        }

        if (getStrMeasure5() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure5());
        }

        if (getStrMeasure6() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure6());
        }

        if (getStrMeasure7() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure7());
        }

        if (getStrMeasure8() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure8());
        }

        if (getStrMeasure9() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure9());
        }

        if (getStrMeasure10() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure10());
        }

        if (getStrMeasure11() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure11());
        }

        if (getStrMeasure12() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure12());
        }

        if (getStrMeasure13() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure13());
        }

        if (getStrMeasure14() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure14());
        }

        if (getStrMeasure15() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure15());
        }

        if (getStrMeasure16() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure16());
        }

        if (getStrMeasure17() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure17());
        }

        if (getStrMeasure18() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure18());
        }

        if (getStrMeasure19() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure19());
        }

        if (getStrMeasure20() == null) {
            return measures;
        } else {
            measures.add(getStrMeasure20());
        }

        return measures;
    }

}