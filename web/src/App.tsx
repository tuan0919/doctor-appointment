import './App.css'
import Header from "./components/Header.tsx";
import Footer from "./components/Footer.tsx";
import DoctorList from "./pages/DoctorList.tsx";


function App() {

  return (
    <>
        <Header/>
        <DoctorList/>
        <Footer/>
    </>

  )
}

export default App
