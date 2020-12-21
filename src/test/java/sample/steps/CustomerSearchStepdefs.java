package sample.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class CustomerSearchStepdefs {

    @Given("会員検索画面を開いている。")
    public void 会員検索画面を開いている() {
        open("customer/search");
    }

    @When("検索条件の入力項目「氏名」に{string}を入力する。")
    public void 検索条件の入力項目氏名にを入力する(String name) {
        $("#name").val(name);
    }

    @And("検索ボタンをクリックする。")
    public void 検索ボタンをクリックする() {
        $("button[name='search']").click();
    }

    @Then("会員検索結果一覧画面が表示される。")
    public void 会員検索結果一覧画面が表示される() {
        $("#title").should(Condition.text("会員一覧"));
    }

    @And("検索結果は{int}件である。")
    public void 検索結果は件である(int count) {
        $("#result-count").should(Condition.text(String.valueOf(count)));
    }

    @And("検索条件の入力項目「住所」に{string}を入力する。")
    public void 検索条件の入力項目住所にを入力する(String address) {
        $("#address").val(address);
    }

    @Then("会員ID:{int}の会員詳細画面が表示される。")
    public void 会員idの会員詳細画面が表示される(int customerNo) {
        $("#title").should(Condition.text("会員詳細 - " + String.valueOf(customerNo)));
    }
}
