package br.com.test.swagger;

import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/fruit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    List<Fruit> fruits = new ArrayList<>();

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public List<Fruit> list() {
        return fruits;
    }

    @POST
    public List<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public List<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }

    @GET
    @Path("/car")
    public RestResponse<Car> listAllCar(){
        Car car = new Car("tes", "te","t");
        return RestResponse.ok(car);
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendMultipartData(@MultipartForm MultipartBody data){

        System.out.println("");
        return "dsada";
    };
}
