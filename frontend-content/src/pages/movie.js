import React, { useState, useEffect } from "react";
import Navbar from "../layout/navbar";
import { Card } from "reactstrap";
import Spinner from "../components/spinner-component";
import axios from "axios";

import defaultImage from "../img/default.jpg";

import {
  Metadata,
  MetadataItem,
  Title,
  Synopsis,
  Creators,
} from "./styled-components/components";
import { port } from "../utils/server";
const HomePage = function (props) {
  const [movie, setMovie] = useState(null);

  const [error, setError] = useState("");

  //`http://localhost:8080/RestServiceClient/api/movie/id/${props.history.match.params.title}
  useEffect(() => {
    axios
      .get(
        `http://localhost:${port}/RestServiceClient/api/movie/id/${props.match.params.id}`
      )
      .then((response) => {
        setMovie(response.data);
        // setLoading(false);
      })
      .catch((err) => {
        console.log(err);
        setError("Error getting");
      });
  }, []);

  return (
    <React.Fragment>
      <Navbar />
      {error ? (
        <div className="d-flex justify-content-center">
          <p className="text-danger">{error}</p>
        </div>
      ) : (
        ""
      )}
      {movie ? (
        <section className="home-banner-area" id="home">
          <div className="container">
            <div className="row  text-md-left fullscreen">
              <div className="home-banner left col align-items-center">
                <div>
                  <Title>{movie.title}</Title>
                  <Metadata>
                    <MetadataItem>
                      {movie.released ? movie.released.year : ""}
                    </MetadataItem>
                    <MetadataItem>
                      <span className="maturity-rating">
                        <span
                          style={{
                            border: "1px solid #a1a1a1",
                            padding: "2px 5px",
                          }}
                        >
                          {movie.genre.genre}
                        </span>
                      </span>
                    </MetadataItem>
                    <MetadataItem>
                      <span className="duration">
                        <span className="test_dur_str">{movie.length} min</span>
                      </span>
                    </MetadataItem>
                    {/* <MetadataItem>{movie.genre.genre}</MetadataItem> */}
                  </Metadata>

                  <Synopsis>
                    <div className="title-info-synopsis">{movie.synopsis}</div>
                    <Creators>
                      <div>
                        <span
                          style={{ marginRight: "5px", fontWeight: "bold" }}
                        >
                          Director
                        </span>
                        <span>{movie.director}</span>
                      </div>
                      <div>
                        <span
                          style={{ marginRight: "5px", fontWeight: "bold" }}
                        >
                          Producer:
                        </span>
                        <span>{movie.producer}</span>
                      </div>
                    </Creators>
                  </Synopsis>
                </div>
              </div>
              <div className="home-banner right fullscreen">
                <div className="d-flex align-items-center">
                  <Card
                    style={{
                      padding: "15px 15px",
                      backgroundColor: "white",
                      boxShadow: "0 1px 3px rgba(34, 25, 25, 0.4)",
                    }}
                  >
                    <img
                      className="img-fluid"
                      src={
                        movie.image
                          ? `data:image/jpeg;base64,${movie.image}`
                          : defaultImage
                      }
                      alt=""
                    />
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </section>
      ) : error ? (
        ""
      ) : (
        <Spinner />
      )}
    </React.Fragment>
  );
};

export default HomePage;
