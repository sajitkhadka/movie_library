import React, { useState, useEffect } from "react";
import Navbar from "../layout/navbar";
import { Card } from "reactstrap";
import Spinner from "../components/spinner-component";
import axios from "axios";

import defaultImage from "../img/default.jpg";
import { port } from "../utils/server";

import {
  Metadata,
  MetadataItem,
  Title,
  Synopsis,
  Creators,
} from "./styled-components/components";
const HomePage = function (props) {
  const [show, setShow] = useState(null);

  const [error, setError] = useState("");

  useEffect(() => {
    axios
      .get(
        `http://localhost:${port}/RestServiceClient/api/show/id/${props.match.params.id}`
      )
      .then((response) => {
        setShow(response.data);
      })
      .catch((err) => {
        console.log(err);
        setError("Couldn't load the data.");
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
      {show ? (
        <section className="home-banner-area" id="home">
          <div className="container">
            <div className="row  text-md-left fullscreen">
              <div className="home-banner left col align-items-center">
                <div>
                  <Title>{show.title}</Title>
                  <Metadata>
                    <MetadataItem>
                      {show.released ? show.released.year : ""}
                    </MetadataItem>
                    <MetadataItem>
                      <span className="maturity-rating">
                        <span
                          style={{
                            border: "1px solid #a1a1a1",
                            padding: "2px 5px",
                          }}
                        >
                          {show.genre.genre}
                        </span>
                      </span>
                    </MetadataItem>
                    <MetadataItem>
                      <span className="duration">
                        <span className="test_dur_str">
                          {show.noSeasons} seasons
                        </span>
                      </span>
                    </MetadataItem>
                    {/* <MetadataItem>{show.genre.genre}</MetadataItem> */}
                  </Metadata>

                  <Synopsis>
                    <div className="title-info-synopsis">{show.synopsis}</div>
                    <Creators>
                      <div>
                        <span
                          style={{ marginRight: "5px", fontWeight: "bold" }}
                        >
                          Director
                        </span>
                        <span>{show.director}</span>
                      </div>
                      <div>
                        <span
                          style={{ marginRight: "5px", fontWeight: "bold" }}
                        >
                          Producer:
                        </span>
                        <span>{show.producer}</span>
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
                        show.image
                          ? `data:image/jpeg;base64,${show.image}`
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
