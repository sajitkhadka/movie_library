import React, { useState, useEffect, useRef } from "react";
import mainImage from "../img/landing-page/netflix.svg";
import Navbar from "../layout/navbar";

const HomePage = function (props) {
  return (
    <React.Fragment>
      <Navbar />
      <section className="home-banner-area" id="home">
        <div className="container">
          <div className="row  text-md-left fullscreen">
            <div className="home-banner left col align-items-center">
              <div>
                <h1>Unlimited movies, TV shows, and more.</h1>
                <p className="mx-auto mb-40">Watch anytime</p>
                <a href="/browse/movies" className="primary-btn m-1">
                  Movies
                </a>
                <a href="/browse/shows" className="primary-btn m-1">
                  TV Shows
                </a>
              </div>
            </div>
            <div className="home-banner right fullscreen">
              <img className="img-fluid" src={mainImage} alt="" />
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  );
};

export default HomePage;
