import React, { useEffect, useState } from "react";
import ImageRow from "./browse/ImageRow";
import { Container, Row } from "reactstrap";
import axios from "axios";
import Navbar from "../layout/navbar";
import Spinner from "../components/spinner-component";

// const m = [
//   {
//     id: "5",
//     title: "Forrest Gump",
//     image:
//       "https://images.freeimages.com/images/large-previews/8a1/small-waterfall-1376352.jpg",
//     released: "2019",
//     synopsis: "It is one of the best movie",
//     length: 100,
//     genre: "Adventure",
//     director: "Sajit Khadka",
//     producer: "Sajit Khadka",
//   },
//   {
//     id: "5",
//     title: "Hotel Califorina",
//     image:
//       "https://images.freeimages.com/images/large-previews/1c9/maine-at-4-45-am-1370871.jpg",
//     released: "2019",
//     synopsis: "It is one of the best movie",
//     length: 100,
//     genre: "Adventure",
//     director: "Sajit Khadka",
//     producer: "Sajit Khadka",
//   },
//   {
//     id: "5",
//     title: "Tarjen",
//     image:
//       "https://images.freeimages.com/images/large-previews/443/horse-1393073.jpg",
//     released: "2019",
//     synopsis: "It is one of the best movie",
//     length: 100,
//     genre: "Adventure",
//     director: "Sajit Khadka",
//     producer: "Sajit Khadka",
//   },
// ];
export default function Browse() {
  const [show, setShows] = useState([]);

  const [error, setError] = useState("");
  useEffect(() => {
    axios
      .get("http://localhost:8888/RestServiceClient/api/show")
      .then((response) => {
        setShows(response.data);
        if (response.data.length <= 0) {
          setError("No data found..");
        }
      })
      .catch((err) => {
        setError("Error getting data");
        console.log(err);
      });
  }, []);

  return (
    <div>
      <Navbar />
      <Container className="themed-container">
        <Row className="pr-4 pl-4">
          <div>
            <h1>TV Shows</h1>
            <p>
              These days, the small screen has some very big things to offer.
              From sitcoms to dramas to travel and talk shows, these are all the
              best programs on TV.
            </p>
          </div>
        </Row>

        {show.length > 0 ? (
          <ImageRow shows={show} />
        ) : error ? (
          error
        ) : (
          <Spinner />
        )}
      </Container>
    </div>
  );
}
