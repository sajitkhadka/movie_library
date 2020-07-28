import React, { Component } from "react";
import loginImage from "../img/loginImage.svg";
import styled from "styled-components/macro";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser, faLock } from "@fortawesome/free-solid-svg-icons";
// import { submitLogin } from '../redux/actions/auth/loginActions';
//import { connect } from "react-redux";
import {
  Pagecontainer,
  InputContainer,
  ButtonLogin,
  Form,
  A,
  Input,
  InputDiv,
} from "./Login/container";
//import classNames from "classnames";
import Navbar from "../layout/navbar";

var Image = styled.div`
  width: 60%;
  background-color: lightcoral;
  background: url(${loginImage}) no-repeat right center/cover;
  flex: 2;
  @media screen and (max-width: 768px) {
    display: none;
  }
`;

class Login extends Component {
  state = {
    email: "",
    password: "",
  };

  handleLogin = (e) => {
    e.preventDefault();
    // this.props.submitLogin(this.state.email, this.state.password);
    // console.log(this.props);
  };
  render() {
    // var messageClassName = classNames({
    //   "text-success":
    //     this.props.login.isAuthenticated ||
    //     (!this.props.login.isAuthenticated && !this.props.login.error),
    //   "text-danger":
    //     !this.props.login.isAuthenticated && this.props.login.error,
    // });

    return (
      <React.Fragment>
        <Navbar />
        <Pagecontainer>
          <Image />
          <InputContainer>
            <Form onSubmit={this.handleLogin}>
              <h1>Welcome to Notelu!</h1>
              {/* {this.props.login.message ? (
                <p className={messageClassName}>{this.props.login.message}</p>
              ) : (
                ''
              )} */}
              <InputDiv>
                <FontAwesomeIcon icon={faUser} />
                <div>
                  <Input
                    type="text"
                    placeholder="Email or Username"
                    value={this.state.email}
                    onChange={(e) => this.setState({ email: e.target.value })}
                  ></Input>
                </div>
              </InputDiv>
              <InputDiv>
                <FontAwesomeIcon icon={faLock} />
                <div>
                  <Input
                    type="password"
                    placeholder="Password"
                    value={this.state.password}
                    onChange={(e) =>
                      this.setState({ password: e.target.value })
                    }
                  ></Input>
                </div>
              </InputDiv>

              <A href="/forgotpassword">Forgot Password?</A>
              <ButtonLogin type="submit" value="Login"></ButtonLogin>
            </Form>
          </InputContainer>
        </Pagecontainer>
      </React.Fragment>
    );
  }
}

// const mapStateToProps = (state) => {
//   return {
//     login: state.auth.login,
//   };
// };

// export default connect(mapStateToProps, {
//   submitLogin,
// })(Login);

export default Login;
