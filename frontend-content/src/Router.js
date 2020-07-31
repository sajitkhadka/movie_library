import React, { lazy } from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

// Route-based code splitting
const HomePage = lazy(() => import("./pages/homepage"));
const BrowseShows = lazy(() => import("./pages/browseShows"));
const BrowseMovies = lazy(() => import("./pages/browseMovies"));
const Movie = lazy(() => import("./pages/movie"));
const Show = lazy(() => import("./pages/show"));
const Error404 = lazy(() => import("./pages/error404"));

class AppRouter extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={HomePage} />
          <Route path="/browse/movies" exact component={BrowseMovies} />
          <Route path="/browse/shows" exact component={BrowseShows} />
          <Route path="/movie/:id" exact component={Movie} />
          <Route path="/show/:id" exact component={Show} />
          <Route component={Error404} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default AppRouter;
