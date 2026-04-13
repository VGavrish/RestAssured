//import entities.*;
//import factories.UserFactory;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.http.Cookie;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//import static org.apache.http.HttpStatus.SC_CREATED;
//import static org.apache.http.HttpStatus.SC_OK;
//
//
//import static io.restassured.RestAssured.given;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class RestAssuredCrudTest {
//    private static final String BASE_URI = "https://qauto.forstudy.space";
//    private static final String SIGNUP_PATH = "/api/auth/signup";
//    private static final String CARS_PATH = "/api/cars";
//    private static final String CARS_MODELS_PATH = "/api/cars/models";
//    private static final String EXPENSES_PATH = "/api/expenses";
//    private static final String EXPENSE_PATH = EXPENSES_PATH + "/{id}";
//
//    private User user;
//    private Cookie sessionCookie;
//    private CarModel carModel;
//    private OutputCar outputCar;
//    private InputExpense inputExpense;
//    private OutputExpenseWrapper outputExpenseWrapper;
//    private OutputExpenses outputExpenses;
//
//
//    @BeforeAll
//    public void setup() {
//        RestAssured.baseURI = BASE_URI;
//        user = UserFactory.createUser();
//    }
//
//    @Test
//    public void crudExpenses(){
//        //створення користуваяча та збереження кукі
//        sessionCookie = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .body(user)
//                .post(SIGNUP_PATH)
//                .then()
//                .statusCode(SC_CREATED)
//                .extract()
//                .response()
//                .getDetailedCookie("sid");
//
//        //визначення які є моделі машин взагалі
//        carModel = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .get(CARS_MODELS_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_OK)
//                .extract()
//                .as(CarModels.class)
//                .data()
//                .get(0);
//
//        //створення конкретної машини з моделью з попереднього запиту
//        outputCar = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .cookie(sessionCookie)
//                .body(generateRandomInputCar(carModel.carBrandId(), carModel.id()))
//                .when()
//                .post(CARS_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_CREATED)
//                .extract()
//                .as(OutputCarWrapper.class)
//                .data();
//
//        //Створення expenses
//        inputExpense = generateRandomInputExpense(outputCar.id(), outputCar.carCreatedAt(), outputCar.mileage());
//        outputExpenseWrapper = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .cookie(sessionCookie)
//                .body(inputExpense)
//                .post(EXPENSES_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_OK)
//                .extract()
//                .as(OutputExpenseWrapper.class);
//
//        //get expenses
//        outputExpenses = given()
//                .contentType(ContentType.JSON)
//                .cookie(sessionCookie)
//                .param("carId", outputExpenseWrapper.data().carId())
//                .param("page",1)
//                .get(EXPENSES_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_OK)
//                .extract()
//                .as(OutputExpenses.class);
//
//        //update expenses
//        InputExpense updatedInputExpense = updateInputExpense(
//                outputCar.id(),
//                outputCar.carCreatedAt(),
//                inputExpense.mileage() + 100
//        );
//        outputExpenseWrapper = given()
//                .contentType(ContentType.JSON)
//                .cookie(sessionCookie)
//                .pathParam("id", outputExpenseWrapper.data().id())
//                .body(updatedInputExpense)
//                .put(EXPENSE_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_OK)
//                .extract()
//                .as(OutputExpenseWrapper.class);
//
//        //delete expense
//        given()
//                .contentType(ContentType.JSON)
//                .cookie(sessionCookie)
//                .pathParam("id", outputExpenseWrapper.data().id())
//                .param("id",outputExpenseWrapper.data().carId())
//                .body(updatedInputExpense)
//                .put(EXPENSE_PATH)
//                .then()
//                .log().all()
//                .statusCode(SC_OK);
//    }
//}
