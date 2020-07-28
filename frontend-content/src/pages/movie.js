import React, { useState, useEffect, useRef } from "react";
import mainImage from "../img/landing-page/netflix.svg";
import Navbar from "../layout/navbar";
import styled from "styled-components";
import movieImage from "./../img/movie_image.jpg";
import { Card } from "reactstrap";

import {
  Metadata,
  MetadataItem,
  Title,
  Synopsis,
  Creators,
} from "./styled-components/components";
const HomePage = function (props) {
  return (
    <React.Fragment>
      <Navbar />
      <section className="home-banner-area" id="home">
        <div className="container">
          <div className="row  text-md-left fullscreen">
            <div className="home-banner left col align-items-center">
              <div>
                <Title>Sons of Anarchy</Title>
                <Metadata>
                  <MetadataItem>2008</MetadataItem>
                  <MetadataItem>
                    <span class="maturity-rating">
                      <span
                        style={{
                          border: "1px solid #a1a1a1",
                          padding: "0 5px",
                        }}
                      >
                        TV-MA{" "}
                      </span>
                    </span>
                  </MetadataItem>
                  <MetadataItem>
                    <span class="duration">
                      <span class="test_dur_str">7 Seasons</span>
                    </span>
                  </MetadataItem>
                  <MetadataItem>Crime</MetadataItem>
                </Metadata>

                <Synopsis>
                  <div
                    class="title-info-synopsis"
                    data-uia="title-info-synopsis"
                  >
                    After seizing control of its town, gun-running motorcycle
                    club the Sons of Anarchy soon butts heads with rival bikers,
                    racist groups and the law.
                  </div>
                  <Creators>
                    <div>
                      <span style={{ marginRight: "5px", fontWeight: "bold" }}>
                        Starring:
                      </span>
                      <span>Charlie Hunnam, Katey Sagal, Ron Perlman</span>
                    </div>
                    <div>
                      <span style={{ marginRight: "5px", fontWeight: "bold" }}>
                        Creators:
                      </span>
                      <span>Kurt Sutter</span>
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
                  <img className="img-fluid" src={movieImage} alt="" />
                </Card>
              </div>
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  );
};

export default HomePage;
