package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.List;

public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        String email = user.getAttribute("email");

    /*
        Admin admin = adminRepository.findByEmail(email).orElseThrow(); // May require exception handling

        if(admin.isPresent()) {
          List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));

          UserDetails userDetails = new User(email, "", grantedAuthorities);

          SecurityContextHolder.getContext().setAuthentication(
                 new UsernamePasswordAuthenticationToken(userDetails, "", grantedAuthorities)
           );
           System.out.println(response.isCommitted() ? "Committed" : "Fail");
           if(response.isCommitted()) {
            System.out.println("Log message: Admin response already Committed");
           }
          getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/admin");
         }
    */
        /*
            // Add case where a coordinator might be also a student with the same email?
            Coordinator coordinator = coordinatorRepository.findByEmail(email).orElseThrow();
            if(coordinator.isPresent()) {
                List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_COORDINATOR"));

                UserDetail userDetails = new User(email, "", grantedAuthorities);

                SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(userDetails, "", grantedAuthorities)
                );
                System.out.println(response.isCommitted() ? "Committed" : "Fail");
                if(response.isCommitted()) {
                    System.out.println("Log message: Coordinator Response already committed");
                }
                // Maybe change redirect to a projects view?
                getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/projects/{projectId}/editions/{editionId}/coordinator-participations");
            }
         */

        /*
           Student student = studentRepository.findByEmail(email).orElseThrow(); // May require exception handling
           Application application = applicationRepository.findByEmail(email).orElseThrow(); // May require exception handling
           StudentParticipation studentParticipation = studentParticipationRepository.findByEmailAndExpireDateBefore(email, LocalDate.now()); // May require exception handling

           
           if(student.isPresent()) {
            if(application.isPresent() && application.selected == true) {
                    List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));

                    UserDetail userDetails = new User(email, "", grantedAuthorities);
    
                    SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(userDetails, "", grantedAuthorities)
                    );

                    System.out.println(response.isCommitted() ? "Committed" : "Fail");
                    if(response.isCommitted()) {
                        System.out.println("Log message: Student response already committed");
                    }

                // Student exists and has participation
                if (studentParticipation.isPresent()) {
                    // redirect to student's 'home-page'
                    getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/projects/{projectId}/editions/{editionId}/student-participations");
                    ); 
                } else {
                    // Student exists but doesn't have participation
                    getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/createparticipationtoexistentstudent"); // Load form with student's data to 'update' info on submit?
                }
             }
             // Student doesn't exist but have a selected application
            } else {
                if(application.isPresent() && application.selected == true) {
                    List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));

                    UserDetail userDetails = new User(email, "", grantedAuthorities);

                    SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(userDetails, "", grantedAuthorities)
                    );
                    // redirect to student form endpoint via student controller
                    getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/applications/{applicationId}/finish-project-application");
                }
            }
            // Student doesn't exist and have no selected application.

           getRedirectStrategy().sendRedirect(request, response, "http://localhost:8080/notallowedpageandlogout");
        */

    }
}
