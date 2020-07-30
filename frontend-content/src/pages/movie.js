import React, { useState, useEffect, useRef } from "react";
import mainImage from "../img/landing-page/netflix.svg";
import Navbar from "../layout/navbar";
import styled from "styled-components";
import movieImage from "./../img/movie_image.jpg";
import { Card } from "reactstrap";
import Spinner from "../components/spinner-component";
import axios from "axios";

import {
  Metadata,
  MetadataItem,
  Title,
  Synopsis,
  Creators,
} from "./styled-components/components";
const HomePage = function (props) {
  const [movie, setMovie] = useState([]);

  const [error, setError] = useState("");

  //`http://localhost:8080/RestServiceClient/api/movie/id/${props.history.match.params.title}
  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/RestServiceClient/api/movie/id/${props.match.params.title}`
      )
      .then((response) => {
        setMovie(response.data);
        // setLoading(false);
      })
      .catch((err) => {
        console.log(err);
        setError("Sorry there was error loading the page. Try again later.");
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
      {movie.length ? (
        <section className="home-banner-area" id="home">
          <div className="container">
            <div className="row  text-md-left fullscreen">
              <div className="home-banner left col align-items-center">
                <div>
                  <Title>{movie.title}</Title>
                  <Metadata>
                    <MetadataItem>
                      {movie.released ? movie.released.getFullYear() : "2000"}
                    </MetadataItem>
                    <MetadataItem>
                      <span class="maturity-rating">
                        <span
                          style={{
                            border: "1px solid #a1a1a1",
                            padding: "0 5px",
                          }}
                        >
                          PG
                        </span>
                      </span>
                    </MetadataItem>
                    <MetadataItem>
                      <span class="duration">
                        <span class="test_dur_str">{movie.length} min</span>
                      </span>
                    </MetadataItem>
                    <MetadataItem>{movie.genre.genre}</MetadataItem>
                  </Metadata>

                  <Synopsis>
                    <div
                      class="title-info-synopsis"
                      data-uia="title-info-synopsis"
                    >
                      {movie.synopsis}
                    </div>
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
                      src={`data:image/jpeg;base64,${movie.image}`}
                      alt=""
                    />
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </section>
      ) : (
        <Spinner />
      )}
    </React.Fragment>
  );
};

export default HomePage;
