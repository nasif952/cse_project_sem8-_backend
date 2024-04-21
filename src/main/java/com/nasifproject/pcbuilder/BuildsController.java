package com.nasifproject.pcbuilder;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/builds")
public class BuildsController {
    @Autowired
    // will need to refer service class here
    private BuildsService buildsService;

    @GetMapping
    public ResponseEntity<List<PcBuilds>> getallBuilds(){
        return new ResponseEntity<List<PcBuilds>>(buildsService.allBuilds(),HttpStatus.OK);
    }
    @GetMapping("/{buildid}")
    //Pathvariable >> passing the information through mapping as a path variable
    // whatever we are getting trough the path variable , we wanna convert that to object id . called id.
    public ResponseEntity<Optional<PcBuilds>> getSingleBuild(@PathVariable String buildid){
         return new ResponseEntity<Optional<PcBuilds>>(buildsService.SingleBuild(buildid),HttpStatus.OK);
    }
    //////////////////////////////////////////////////////////////////////////
    @PostMapping
    public ResponseEntity<PcBuilds> addBuild(@RequestBody PcBuilds build) {
        PcBuilds savedBuild = buildsService.addBuild(build);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuild);
    }

    @PutMapping("/{buildid}")
    public ResponseEntity<PcBuilds> updateBuild(@PathVariable String buildid, @RequestBody PcBuilds buildDetails) {
        Optional<PcBuilds> updatedBuild = buildsService.updateBuild(buildid, buildDetails);
        return updatedBuild.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{buildid}")
    public ResponseEntity<Void> deleteBuild(@PathVariable String buildid) {
        buildsService.deleteBuild(buildid);
        return ResponseEntity.noContent().build();
    }
//////////////////////////////////////////////////////////////////////////

}



