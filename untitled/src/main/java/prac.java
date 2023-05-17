import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class prac {
  public static void main(String[] args) {
    String pokemonName = "pikachu";
    String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(new URI(url));
      CloseableHttpResponse response = httpClient.execute(request);

      JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
      String name = json.getString("name");
      int height = json.getInt("height");
      int weight = json.getInt("weight");
      JSONArray abilitiesJson = json.getJSONArray("abilities");
      String[] abilities = new String[abilitiesJson.length()];
      for (int i = 0; i < abilitiesJson.length(); i++) {
        abilities[i] = abilitiesJson.getJSONObject(i).getJSONObject("ability").getString("name");
      }

      System.out.println("Name: " + name);
      System.out.println("Height: " + height);
      System.out.println("Weight: " + weight);
      System.out.println("Abilities: " + String.join(", ", abilities));
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
