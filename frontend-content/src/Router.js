import React, { lazy } from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

// Route-based code splitting
const Login = lazy(() => import("./pages/login"));
const Signup = lazy(() => import("./pages/signup"));
const HomePage = lazy(() => import("./pages/homepage"));
const BrowseShows = lazy(() => import("./pages/browseShows"));
const BrowseMovies = lazy(() => import("./pages/browseMovies"));
const Movie = lazy(() => import("./pages/movie"));
const Error404 = lazy(() => import("./pages/error404"));

class AppRouter extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={HomePage} />
          <Route path="/login" exact component={Login} />
          <Route path="/signup" exact component={Signup} />
          <Route path="/browse/movies" exact component={BrowseShows} />
          <Route path="/browse/shows" exact component={BrowseMovies} />
          <Route path="/title/:title" exact component={Movie} />
          <Route component={Error404} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default AppRouter;
