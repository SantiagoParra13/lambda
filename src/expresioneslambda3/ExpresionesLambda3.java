package expresioneslambda3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExpresionesLambda3 {

    public static void main(String[] args) {

        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Jurassic Park", "Steven Spielberg", 1993));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("The Shawshank Redemption", "Frank Darabont", 1994));
        peliculas.add(new Pelicula("The Godfather", "Francis Ford Coppola", 1972));
        peliculas.add(new Pelicula("Inception", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("Forrest Gump", "Robert Zemeckis", 1994));
        peliculas.add(new Pelicula("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999));
        peliculas.add(new Pelicula("The Dark Knight", "Christopher Nolan", 2008));
        peliculas.add(new Pelicula("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2001));

        //obtner un sublistado con las peliculas estrenados en el siglo 21
        List<Pelicula> estrenosSigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());
        estrenosSigloXXI.forEach(System.out::println);

        //mostrar por pantalla, separadas por , los titulos de las peliculas de una direcor
        System.out.println("--------------------------------------------------------------------");
        String listadoPeliculasEsece = peliculas.stream()
                .filter(a -> a.getDirector().equals("Steven Spielberg"))
                .map(t -> t.getTitulo())
                .collect(Collectors.joining(", ", "Nombres de las peliculas de Steven Spielberg ", ""));
        System.out.println(listadoPeliculasEsece);

        //obtener un sublistado con los nombres de las peliculas ordenasdas alfabeticamente
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Peliculas ordenadas Alfabeticamente");
        List<String> peliculasOrdenadas = peliculas.stream()
                .map(p -> p.getTitulo())
                .sorted((p1, p2) -> p1.compareTo(p2))
                .collect(Collectors.toList());
        peliculasOrdenadas.forEach(System.out::println);

        //mostrar la pelicula mas reciente
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Pelicula mas reciente");
        Optional<Pelicula> peliculaEstrenada = peliculas.stream()
                .max((p1, p2) -> Integer.compare(p1.getEstreno(), p2.getEstreno()));

        String datosPelicula = (peliculaEstrenada.isPresent()) 
              ? String.valueOf(peliculaEstrenada.get())
                : "No se han encontradoi peliculas";
        System.out.println(datosPelicula);

    }

}
