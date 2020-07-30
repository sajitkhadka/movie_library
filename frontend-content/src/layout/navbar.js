import React, { Component } from "react";
import logo from "../img/logo.svg";
import { Link } from "react-router-dom";
import styled from "styled-components/macro";
import Container from "./components/container";
import { Link as Lin } from "react-scroll";

var Nav = styled.nav`
  z-index: 1;
  ${(props) => {
    return props.sticky
      ? "position:sticky; top: 0; background-color:#fff; box-shadow: 4px 0 20px -10px rgba(0, 0, 0, 0.2);"
      : "position:relative; background-color: transparent";
  }}
`;

var Row = styled.div`
  @media screen and (min-width: 640px) {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: ${(props) => (props.sticky ? "" : "2px solid orange")};
    padding: 0 20px;
  }

  ul a {
    background: transparent;
    margin-right: 25px;
  }
`;

var LogoButton = styled.div`
  background-color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid orange;
`;
var Logo = styled.div`
  img {
    margin-top: 10px;
    height: 35px;
  }
`;
var NavButton = styled.div`
  border: 1px solid black;
  display: inline-block;
  @media screen and (min-width: 640px) {
    display: none;
  }
  .bar {
    width: 30px;
    height: 4px;
    margin: 4px;
    color: rgb(139, 139, 137);
    background: gray;
    cursor: pointer;
  }
`;

var NavList = styled.ul`
  list-style: none;
  height: ${(props) => (props.show ? "auto" : "0px")};
  overflow: hidden;
  transition: all 0.5s ease;

  li a {
    color: black;
    text-decoration: none;
    padding: 10px;
    display: flex;
    transition: all 0.5s ease;
    font-size: 18px;
  }
  li a:hover {
    background-color: blueviolet;
    padding-left: 20px;
  }

  @media screen and (min-width: 640px) {
    display: flex;
    list-style-type: none;
    height: auto;

    li a:hover {
      background-color: #aaa;
      padding-left: 10px;
      color: #fff;
      border-radius: 5px;
    }
  }
`;

class Navbar extends Component {
  state = {
    isOpen: false,
  };

  handleClick = () => {
    this.setState({
      isOpen: !this.state.isOpen,
    });
  };

  render() {
    return (
      <Nav sticky={this.props.sticky}>
        <Container>
          <Row sticky={this.props.sticky}>
            <LogoButton>
              <Logo>
                <Link to="/">
                  <img src={logo} alt="notelu_logo"></img>
                </Link>
              </Logo>

              <NavButton onClick={this.handleClick}>
                <div className="bar"></div>
                <div className="bar"></div>
                <div className="bar"></div>
                <div className="bar"></div>
              </NavButton>
            </LogoButton>
            <NavList show={this.state.isOpen}>
              <li>
                <Link to="/browse/movies">Movies</Link>
              </li>
              <li>
                <Link to="/browse/shows">TV Shows</Link>
              </li>
            </NavList>
          </Row>
        </Container>
      </Nav>
    );
  }
}

export default Navbar;
